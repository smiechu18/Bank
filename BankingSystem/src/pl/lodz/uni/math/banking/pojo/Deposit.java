package pl.lodz.uni.math.banking.pojo;
public class Deposit extends Transaction {
	public Deposit(Account receiverAccount, String title, double amount) {
		this.setTransactionStatus(EnumTransactionStatus.Accepted);
		this.setReceiverAccount(receiverAccount);
		this.title = title;
		this.setTransactionNumber(Integer.parseInt(DEPOSIT_NUMBER_BASE) + transactionCounter);
		this.setAmount(amount);
		transactionCounter++;
	}

	private final String DEPOSIT_NUMBER_BASE = "10001";
}

