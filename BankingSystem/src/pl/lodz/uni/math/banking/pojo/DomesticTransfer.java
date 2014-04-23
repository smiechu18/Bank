package pl.lodz.uni.math.banking.pojo;

import java.util.GregorianCalendar;

public class DomesticTransfer extends Transaction implements Itransfer{
	public DomesticTransfer(Account receiverAccount, Account senderAccount,
			String title, double amount) {
		this.setTransactionStatus(EnumTransactionStatus.Accepted);
		this.setReceiverAccount(receiverAccount);
		this.setSenderAccount(senderAccount);
		this.title = title;
		this.setTransactionNumber(DOMESTIC_TRANSFER_NUMBER_BASE + transactionCounter);
		this.setAmount(amount);
		this.setTransactionDate(new GregorianCalendar());
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

	private final int DOMESTIC_TRANSFER_NUMBER_BASE = 10000;
	private Account senderAccount;
	private double balanceAfterTransactionSender;
}
