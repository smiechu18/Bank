package pl.lodz.uni.math.banking.dao;

import java.util.GregorianCalendar;
import java.util.List;

import pl.lodz.uni.math.banking.pojo.Account;
import pl.lodz.uni.math.banking.pojo.Deposit;
import pl.lodz.uni.math.banking.pojo.DomesticTransfer;
import pl.lodz.uni.math.banking.pojo.ForeignTransfer;
import pl.lodz.uni.math.banking.pojo.Transaction;
import pl.lodz.uni.math.banking.pojo.User;

public interface TransactionDao {

	void cancelTransaction(Transaction transaction);

	void confirmTransaction(Transaction transaction);

	boolean createDeposit(Deposit deposit);

	boolean createForeignTransfer(ForeignTransfer foreignTransfer);

	boolean createDomesticTransfe(DomesticTransfer domesticTransfer);

	List<Transaction> getConfirmedTransactionList();

	Transaction getWaitingTransactionByNumber(int transactionNumber);

	List<Transaction> getCanceledTransactionList();

	void showHistory(User user);

	void showAccountHistory(Account accountByNumber);

	void showAccountHistory(Account accountByNumber, GregorianCalendar t);


}
