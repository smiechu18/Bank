package pl.lodz.uni.math.banking.pojo;

public class Deposit extends Transaction {
	public Deposit(Account receiverAccount, String title, String number,
			double amount) {
		this.setTransactionStatus(EnumtransactionStatus.accepted);
		this.setReceiverAccount(receiverAccount);
		this.title = title;
		this.transactionNumber = DEPOSITNUMBERBASE + number;
		this.amount = amount;

	}

	private final String DEPOSITNUMBERBASE = "10001";
}
