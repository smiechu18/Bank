package pl.lodz.uni.math.banking.pojo;

public interface Itransfer {
	
	Account getSenderAccount();
	
	double getBalanceAfterTransactionSender();
	
	void setBalanceAfterTransactionSender(double balanceAfterTransactionSender);
}
