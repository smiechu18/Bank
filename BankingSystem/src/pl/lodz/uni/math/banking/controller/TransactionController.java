package pl.lodz.uni.math.banking.controller;

import java.util.List;

import pl.lodz.uni.math.banking.pojo.*;

public interface TransactionController {


	boolean createDeposit(Deposit deposit);

	boolean createForeignTransfer(ForeignTransfer foreignTransfer);

	boolean createDomesticTransfer(DomesticTransfer domesticTransfer);
	
	Transaction getWaitingTransactionByNumber(int transactionNumber);

	void confirmTransaction(Transaction transaction);
	
	void cancelTransaction(Transaction transaction);
	
	List<Transaction> getConfirmedTransactionList();
	
	List<Transaction> getCanceledTransactionList();

}
