package pl.lodz.uni.math.banking.controller;

import java.util.List;

import pl.lodz.uni.math.banking.pojo.*;

public interface TransactionController {

	boolean createDeposit(Deposit deposit);

	boolean createForeignTransfer(ForeignTransfer foreignTransfer);

	boolean createDomesticTransfer(DomesticTransfer domesticTransfer);

	List<Transaction> getAllTransaction();
	
	void confirmTransaction(Transaction transaction);
	
	void cancelTransaction(Transaction transaction);
	
	List<Transaction> getTransfersToTheAccount(Account account);

}
