package pl.lodz.uni.math.banking.pojo;

public class DomesticTransfer extends Transaction implements Itransfer{
	public DomesticTransfer(Account receiverAccount, Account senderAccount,
			String title, double amount) {
		this.setTransactionStatus(EnumTransactionStatus.Accepted);
		this.setReceiverAccount(receiverAccount);
		this.setSenderAccount(senderAccount);
		this.title = title;
		this.transactionNumber = DOMESTIC_TRANSFER_NUMBER_BASE + transactionCounter;
		this.setAmount(amount);
		transactionCounter++;
	}

	public Account getSenderAccount() {
		return senderAccount;
	}
	public void setSenderAccount(Account senderAccount) {
		this.senderAccount = senderAccount;
	}

	private final String DOMESTIC_TRANSFER_NUMBER_BASE = "10001";
	private Account senderAccount;
}
