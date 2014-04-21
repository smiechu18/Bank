package pl.lodz.uni.math.banking.dao;

import java.util.List;

import pl.lodz.uni.math.banking.pojo.Deposit;
import pl.lodz.uni.math.banking.pojo.DomesticTransfer;
import pl.lodz.uni.math.banking.pojo.ForeignTransfer;
import pl.lodz.uni.math.banking.pojo.Transaction;

public interface TransactionDao {

	void cancelTransaction(Transaction transaction);

	void confirmTransaction(Transaction transaction);

	boolean createDeposit(Deposit deposit);

	boolean createForeignTransfer(ForeignTransfer foreignTransfer);

	boolean createDomesticTransfe(DomesticTransfer domesticTransfer);

	List<Transaction> getConfirmedTransactionList();

	Transaction getWaitingTransactionByNumber(int transactionNumber);

	List<Transaction> getCanceledTransactionList();


}
