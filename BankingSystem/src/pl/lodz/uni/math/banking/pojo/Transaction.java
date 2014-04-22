package pl.lodz.uni.math.banking.pojo;

import java.util.GregorianCalendar;

public class Transaction {
	
	private EnumTransactionStatus transactionStatus;
	private Account receiverAccount;
	protected String title;
	private int transactionNumber;
	private double amount;
	private double balanceAfterTransactionReceiver;
	private GregorianCalendar transactionDate;
	protected String receiverName;
	protected String receiverSurname;
	protected String receiverAddress;
	protected static int transactionCounter = 0;
	
	public EnumTransactionStatus getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(EnumTransactionStatus transactionStatus) {
		 this.transactionStatus = transactionStatus;
	}
	public Account getReceiverAccount() {
		return receiverAccount;
	}
	public void setReceiverAccount(Account receiverAccount) {
		this.receiverAccount = receiverAccount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getTransactionNumber() {
		return transactionNumber;
	}
	public void setTransactionNumber(int transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	public double getBalanceAfterTransactionReceiver() {
		return balanceAfterTransactionReceiver;
	}
	public void setBalanceAfterTransactionReceiver(double balanceAfterTransactionReceiver) {
		this.balanceAfterTransactionReceiver = balanceAfterTransactionReceiver;
	}
	public GregorianCalendar getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(GregorianCalendar transactionDate) {
		this.transactionDate = transactionDate;
	}
	
}
