package pl.lodz.uni.math.banking.dao;

import java.util.ArrayList;
import java.util.GregorianCalendar;
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
			transaction.getReceiverAccount().setBalance(
					transaction.getReceiverAccount().getBalance()
							+ transaction.getAmount());
			transaction.setBalanceAfterTransactionReceiver(transaction.getReceiverAccount().getBalance());
			if(transaction instanceof Itransfer){
				((Itransfer)transaction).setBalanceAfterTransactionSender(((Itransfer)transaction).getSenderAccount().getBalance());
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
		if( ! foreignTransfer.getSenderAccount().getSwift().equals(foreignTransfer.getReceiverAccount().getSwift())){
			return false;
		}
		else if(foreignTransfer.getSenderAccount().equals(foreignTransfer.getReceiverAccount())){
			return false;
		}
		else if(foreignTransfer.getSenderAccount().getBalance() < foreignTransfer.getAmount()){
			return false;
		}
		foreignTransfer.getSenderAccount().setBalance(foreignTransfer.getSenderAccount().getBalance() - foreignTransfer.getAmount());
		return waitingTransactions.add(foreignTransfer);
	}

	public boolean createDomesticTransfe(DomesticTransfer domesticTransfer) {
		if(domesticTransfer.getSenderAccount().getSwift().equals(domesticTransfer.getReceiverAccount().getSwift())){
			return false;
		}
		else if(domesticTransfer.getSenderAccount().equals(domesticTransfer.getReceiverAccount())){
			return false;
		}
		else if(domesticTransfer.getSenderAccount().getBalance()<domesticTransfer.getAmount()){
			return false;
		}
		domesticTransfer.getSenderAccount().setBalance(domesticTransfer.getSenderAccount().getBalance() - domesticTransfer.getAmount());
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

	private void setCanceledTransactionList(ArrayList<Transaction> canceledTransactions) {
		this.canceledTransactions = canceledTransactions;
	}

	public void showHistory(User user) {
		for(Account a : user.getAccountsList()){
			showAccountHistory(a);
		}
	}

	public void showAccountHistory(Account account) {
		System.out.println(account.getNumber());
		for(Transaction t : confirmedTransactions){
			if(t.getReceiverAccount().equals(account)){
				System.out.println("Balance after transaction: " + t.getBalanceAfterTransactionReceiver());
			}
			if(t instanceof Itransfer && ((Itransfer) t).getSenderAccount().equals(account)){
				System.out.println("Balance after transaction: " + ((Itransfer) t).getBalanceAfterTransactionSender());
			}
		}
	}

	public void showAccountHistory(Account account, GregorianCalendar gc) {
		System.out.println(account.getNumber() + " after "+ gc.getTime());
		for(Transaction t : confirmedTransactions){
			if(t.getReceiverAccount().equals(account) && t.getTransactionDate().getTimeInMillis() > gc.getTimeInMillis()){
				System.out.println("Balance after transaction: " + t.getBalanceAfterTransactionReceiver());
			}
			if(t instanceof Itransfer && ((Itransfer) t).getSenderAccount().equals(account) && t.getTransactionDate().getTimeInMillis() > gc.getTimeInMillis()){
				System.out.println("Balance after transaction: " + ((Itransfer) t).getBalanceAfterTransactionSender());
			}
		}
	}

}
