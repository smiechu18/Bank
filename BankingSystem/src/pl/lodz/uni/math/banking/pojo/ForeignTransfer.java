package pl.lodz.uni.math.banking.pojo;

import java.util.GregorianCalendar;

public class ForeignTransfer extends Transaction implements Itransfer{
	public ForeignTransfer(Account receiverAccount, Account senderAccount,
			String title, double amount) {
		this.setTransactionStatus(EnumTransactionStatus.Accepted);
		this.setReceiverAccount(receiverAccount);
		this.setSenderAccount(senderAccount);
		this.title = title;
		this.setTransactionNumber(Integer.parseInt(FOREIGN_TRANSFER_NUMBER_BASE) + transactionCounter);
		this.setAmount(amount);
		this.setTransactionDate(new GregorianCalendar());
		transactionCounter++;
	}
	public Account getSenderAccount() {
		return senderAccount;
	}
	public void setSenderAccount(Account senderAccount) {
		this.senderAccount = senderAccount;
	}
	public double getBalanceAfterTransactionSender() {
		return balanceAfterTransactionSender;
	}
	public void setBalanceAfterTransactionSender(
			double balanceAfterTransactionSender) {
		this.balanceAfterTransactionSender = balanceAfterTransactionSender;
	}
	private double balanceAfterTransactionSender;
	private Account senderAccount;
	private final String FOREIGN_TRANSFER_NUMBER_BASE = "1";
}
