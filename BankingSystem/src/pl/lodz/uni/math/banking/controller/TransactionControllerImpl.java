package pl.lodz.uni.math.banking.controller;

import java.util.List;

import pl.lodz.uni.math.banking.dao.TransactionDao;
import pl.lodz.uni.math.banking.engine.BinProvider;
import pl.lodz.uni.math.banking.pojo.Account;
import pl.lodz.uni.math.banking.pojo.Deposit;
import pl.lodz.uni.math.banking.pojo.DomesticTransfer;
import pl.lodz.uni.math.banking.pojo.ForeignTransfer;
import pl.lodz.uni.math.banking.pojo.Transaction;

public class TransactionControllerImpl implements TransactionController {
	private TransactionDao transactionDao;
	private BinProvider binProvider;
	public TransactionControllerImpl() {
		binProvider = new BinProvider();
		transactionDao = binProvider.getTransactionDaoImpl();
	}

	public boolean createDeposit(Deposit deposit) {
		return transactionDao.createTransaction(deposit);
	}

	public boolean createForeignTransfer(ForeignTransfer foreignTransfer) {
		return transactionDao.createTransaction(foreignTransfer);
	}

	public boolean createDomesticTransfer(DomesticTransfer domesticTransfer) {
		return transactionDao.createTransaction(domesticTransfer);
	}

	public List<Transaction> getAllTransaction() {
		return transactionDao.getAllTransaction();
	}

	@Override
	public void confirmTransaction(Transaction transaction) {
		 transactionDao.confirmTransaction(transaction);
	}

	@Override
	public void cancelTransaction(Transaction transaction) {
		 transactionDao.cancelTransaction(transaction);
		
	}

	@Override
	public List<Transaction> getTransfersToTheAccount(Account account) {
		return transactionDao.getTransfersToTheAccount(account);
	}


}
