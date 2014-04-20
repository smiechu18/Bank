package pl.lodz.uni.math.banking.dao;

import java.util.ArrayList;
import java.util.List;

import pl.lodz.uni.math.banking.pojo.*;

public class TransactionDaoMemImpl implements TransactionDao {
	private ArrayList<Transaction> waitingTransactions;
	private ArrayList<Transaction> canceledTransactions;
	private ArrayList<Transaction> confirmedTransactions;

	public TransactionDaoMemImpl() {
		waitingTransactions = new ArrayList<Transaction>();
	}

	public void cancelTransaction(Transaction transaction) {
		if (waitingTransactions.contains(transaction)) {
			transaction.setTransactionStatus(EnumTransactionStatus.Canceled);
			if (transaction instanceof Itransfer) {
				((Itransfer) transaction).getSenderAccount().setBalance(
						((Itransfer) transaction).getSenderAccount()
								.getBalance() + transaction.getAmount());
			}
			canceledTransactions.add(transaction);
			waitingTransactions.remove(transaction);
		}
	}

	public void confirmTransaction(Transaction transaction) {
		if (waitingTransactions.contains(transaction)) {
			transaction.setTransactionStatus(EnumTransactionStatus.Confirmed);
			if (transaction instanceof Itransfer) {
				transaction.getReceiverAccount().setBalance(
						transaction.getReceiverAccount().getBalance()
								+ transaction.getAmount());
			}
			confirmedTransactions.add(transaction);
			waitingTransactions.remove(transaction);
		}
	}

	public boolean createDeposit(Deposit deposit) {
		return waitingTransactions.add(deposit);
	}

	public boolean createForeignTransfer(ForeignTransfer foreignTransfer) {
		if (!foreignTransfer.getReceiverAccount().getSwift()
				.equals(foreignTransfer.getSenderAccount().getSwift())) {
			foreignTransfer.getSenderAccount().setBalance(
					foreignTransfer.getSenderAccount().getBalance()
							- foreignTransfer.getAmount());
			return waitingTransactions.add(foreignTransfer);
		}
		return false;
	}

	public boolean createDomesticTransfe(DomesticTransfer domesticTransfer) {
		if (domesticTransfer.getReceiverAccount().getSwift()
				.equals(domesticTransfer.getSenderAccount().getSwift())) {
			domesticTransfer.getSenderAccount().setBalance(
					domesticTransfer.getSenderAccount().getBalance()
							- domesticTransfer.getAmount());
			return waitingTransactions.add(domesticTransfer);
		}
		return false;
	}

	public List<Transaction> getConfirmedTransactionList() {
		return confirmedTransactions;
	}

}
