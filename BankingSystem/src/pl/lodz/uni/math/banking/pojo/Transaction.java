package pl.lodz.uni.math.banking.pojo;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

public abstract class Transaction {
	
	private EnumTransactionStatus transactionStatus;
	private Account receiverAccount;
	protected String title;
	private int transactionNumber;
	private BigDecimal amount;
	private BigDecimal balanceAfterTransactionReceiver;
	private GregorianCalendar transactionDate;
	protected String receiverName;
	protected String receiverSurname;
	protected String receiverAddress;
	protected static int transactionCounter = 0;
	
	{
		transactionCounter++;
	}
	
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
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = new BigDecimal(amount);
	}
	public int getTransactionNumber() {
		return transactionNumber;
	}
	public void setTransactionNumber(int transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	public BigDecimal getBalanceAfterTransactionReceiver() {
		return balanceAfterTransactionReceiver;
	}
	public void setBalanceAfterTransactionReceiver(double balanceAfterTransactionReceiver) {
		this.balanceAfterTransactionReceiver = new BigDecimal(balanceAfterTransactionReceiver);
	}
	public GregorianCalendar getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(GregorianCalendar transactionDate) {
		this.transactionDate = transactionDate;
	}
	
}
