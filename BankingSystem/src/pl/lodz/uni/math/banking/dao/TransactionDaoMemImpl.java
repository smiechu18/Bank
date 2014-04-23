package pl.lodz.uni.math.banking.dao;

import java.math.BigDecimal;
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
			if (transaction instanceof Itransfer) {((Itransfer) transaction).getSenderAccount().setBalance(
						((Itransfer) transaction).getSenderAccount().getBalance().add(transaction.getAmount()));
			}
			getCanceledTransactionList().add(transaction);
			waitingTransactions.remove(transaction);
		}
	}

	public void confirmTransaction(Transaction transaction) {
		if (waitingTransactions.contains(transaction)) {
			transaction.setTransactionStatus(EnumTransactionStatus.Confirmed);
			transaction.getReceiverAccount().setBalance(transaction.getReceiverAccount().
					getBalance().add(transaction.getAmount()));
			transaction.setBalanceAfterTransactionReceiver(transaction.getReceiverAccount().getBalance().doubleValue());
			if(transaction instanceof Itransfer){
				((Itransfer)transaction).setBalanceAfterTransactionSender(((Itransfer)transaction).getSenderAccount()
						.getBalance().doubleValue());
			}
			confirmedTransactions.add(transaction);
			waitingTransactions.remove(transaction);
		}
	}

	public boolean createDeposit(Deposit deposit) {
		if(deposit == null){
			return false;
		}
		else if(deposit.getReceiverAccount() == null || deposit.getAmount().compareTo(new BigDecimal(0)) != 1){
			return false;
		}
		return waitingTransactions.add(deposit);
	}

	public boolean createForeignTransfer(ForeignTransfer foreignTransfer) {
		if(foreignTransfer == null){
			return false;
		}
		else if( ! foreignTransfer.getSenderAccount().getSwift().equals(foreignTransfer.getReceiverAccount().getSwift())){
			return false;
		}
		else if(foreignTransfer.getSenderAccount().equals(foreignTransfer.getReceiverAccount()) 
				|| foreignTransfer.getAmount().compareTo(new BigDecimal(0)) != -1){
			return false;
		}
		else if(foreignTransfer.getSenderAccount().getBalance().compareTo(foreignTransfer.getAmount()) == 1){
			return false;
		}
		foreignTransfer.getSenderAccount().setBalance(foreignTransfer.getSenderAccount().getBalance().subtract(foreignTransfer.getAmount()));
		return waitingTransactions.add(foreignTransfer);
	}

	public boolean createDomesticTransfe(DomesticTransfer domesticTransfer) {
		if(domesticTransfer == null){
			return false;
		}
		else if(domesticTransfer.getSenderAccount().getSwift().equals(domesticTransfer.getReceiverAccount().getSwift())){
			return false;
		}
		else if(domesticTransfer.getSenderAccount().equals(domesticTransfer.getReceiverAccount())
				||domesticTransfer.getAmount().compareTo(new BigDecimal(0)) != 1){
			return false;
		}
		else if(domesticTransfer.getSenderAccount().getBalance().compareTo(domesticTransfer.getAmount()) == -1){
			return false;
		}
		domesticTransfer.getSenderAccount().setBalance(domesticTransfer.getSenderAccount().getBalance().subtract(domesticTransfer.getAmount()));
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
