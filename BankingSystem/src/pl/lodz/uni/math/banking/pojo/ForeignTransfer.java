package pl.lodz.uni.math.banking.pojo;

public class ForeignTransfer extends Transaction implements Itransfer{
	public ForeignTransfer(Account receiverAccount, Account senderAccount,
			String title, double amount) {
		this.setTransactionStatus(EnumTransactionStatus.Accepted);
		this.setReceiverAccount(receiverAccount);
		this.setSenderAccount(senderAccount);
		this.title = title;
		this.transactionNumber = FOREIGN_TRANSFER_NUMBER_BASE
				+ transactionCounter;
		this.setAmount(amount);
		transactionCounter++;
	}
	public Account getSenderAccount() {
		return senderAccount;
	}
	public void setSenderAccount(Account senderAccount) {
		this.senderAccount = senderAccount;
	}
	private Account senderAccount;
	private final String FOREIGN_TRANSFER_NUMBER_BASE = "1";
}
