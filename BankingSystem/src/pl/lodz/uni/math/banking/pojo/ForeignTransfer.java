package pl.lodz.uni.math.banking.pojo;

public class ForeignTransfer extends Transfer {
	public ForeignTransfer(Account receiverAccount, Account senderAccount, String title,
			String number, double amount, String name, String surname,
			String address, int swift) {
		this.setTransactionStatus(EnumtransactionStatus.accepted);
		this.setReceiverAccount(receiverAccount);
		
		this.title = title;
		this.transactionNumber = FOREIGN_TRANSFER_NUMBER_BASE + number;
		this.amount = amount;
		this.receiverName = name;
		this.receiverSurname = surname;
		this.receiverAddress = address;
		this.swift = swift;
	}
	private int swift;
	private final String FOREIGN_TRANSFER_NUMBER_BASE = "1";
}
