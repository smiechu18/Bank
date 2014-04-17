package pl.lodz.uni.math.banking.pojo;

public class Transaction {
	
	private EnumtransactionStatus transactionStatus;
	private Account receiverAccount;
	protected String title;
	protected String transactionNumber;
	protected double amount;
	protected double balanceAfterTransaction;
	protected String transactionDate;
	protected static int transactionId = 0;
	
	public EnumtransactionStatus getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(EnumtransactionStatus transactionStatus) {
		 this.transactionStatus = transactionStatus;
	}
	public Account getReceiverAccount() {
		return receiverAccount;
	}
	public void setReceiverAccount(Account receiverAccount) {
		this.receiverAccount = receiverAccount;
	}
}
