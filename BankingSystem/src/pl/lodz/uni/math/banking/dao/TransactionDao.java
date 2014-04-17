package pl.lodz.uni.math.banking.dao;

import java.util.List;

import pl.lodz.uni.math.banking.pojo.Account;
import pl.lodz.uni.math.banking.pojo.Transaction;

public interface TransactionDao {

	boolean createTransaction(Transaction transaction);

	List<Transaction> getAllTransaction();

	void cancelTransaction(Transaction transaction);

	void confirmTransaction(Transaction transaction);

	List<Transaction> getTransfersToTheAccount(Account account);


}
