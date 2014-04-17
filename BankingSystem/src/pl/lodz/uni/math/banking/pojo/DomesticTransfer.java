package pl.lodz.uni.math.banking.pojo;

public class DomesticTransfer extends Transfer {
	public DomesticTransfer(Account receiverAccount, String title,
			String number, String receiverName, String receiverSurname,
			String receiverAddress, double amount) {
		this.setTransactionStatus(EnumtransactionStatus.accepted);
		this.setReceiverAccount(receiverAccount);
		this.title = title;
		this.transactionNumber = DOMESTIC_TRANSFER_NUMBER_BASE + number;
		this.receiverName = receiverName;
		this.receiverSurname = receiverSurname;
		this.receiverAddress = receiverAddress;
		this.amount = amount;
	}

	private final String DOMESTIC_TRANSFER_NUMBER_BASE = "10001";

}
