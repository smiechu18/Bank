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
		setCanceledTransactionList(new ArrayList<Transaction>());
		confirmedTransactions = new ArrayList<Transaction>();
	}

	public void cancelTransaction(Transaction transaction) {
		if (waitingTransactions.contains(transaction)) {
			transaction.setTransactionStatus(EnumTransactionStatus.Canceled);
			if (transaction instanceof Itransfer) {
				((Itransfer) transaction).getSenderAccount().setBalance(
						((Itransfer) transaction).getSenderAccount()
								.getBalance() + transaction.getAmount());
			}
			getCanceledTransactionList().add(transaction);
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
		if(deposit.getReceiverAccount()==null){
			return false;
		}
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
		if(domesticTransfer.getSenderAccount().getSwift() == domesticTransfer.getReceiverAccount().getSwift()){
			return false;
		}
		else if(domesticTransfer.getSenderAccount().equals(domesticTransfer.getReceiverAccount())){
			return false;
		}
		return waitingTransactions.add(domesticTransfer);
	}

	public List<Transaction> getConfirmedTransactionList() {
		return confirmedTransactions;
	}

	public Transaction getWaitingTransactionByNumber(int transactionNumber) {
		Transaction tmp = null;
		for(Transaction t: waitingTransactions){
			if(t.getTransactionNumber() == transactionNumber){
				tmp = t;
			}
		}
		return tmp;
	}

	public ArrayList<Transaction> getCanceledTransactionList() {
		return canceledTransactions;
	}

	public void setCanceledTransactionList(ArrayList<Transaction> canceledTransactions) {
		this.canceledTransactions = canceledTransactions;
	}

}
