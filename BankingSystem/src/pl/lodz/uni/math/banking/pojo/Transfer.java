package pl.lodz.uni.math.banking.pojo;

public abstract class Transfer extends Transaction {

	protected String receiverName;
	protected String receiverSurname;
	protected String receiverAddress;
	private Account senderAccount;
	public Account getSenderAccount() {
		return senderAccount;
	}
	public void setSenderAccount(Account senderAccount) {
		this.senderAccount = senderAccount;
	}
}
