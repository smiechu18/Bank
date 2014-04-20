package pl.lodz.uni.math.banking.controller;

import java.util.List;

import pl.lodz.uni.math.banking.dao.TransactionDao;
import pl.lodz.uni.math.banking.engine.BinProvider;
import pl.lodz.uni.math.banking.pojo.Deposit;
import pl.lodz.uni.math.banking.pojo.DomesticTransfer;
import pl.lodz.uni.math.banking.pojo.ForeignTransfer;
import pl.lodz.uni.math.banking.pojo.Transaction;

public class TransactionControllerImpl implements TransactionController {
	private TransactionDao transactionDao;
	private BinProvider binProvider;
	public TransactionControllerImpl() {
		binProvider = new BinProvider();
		transactionDao = binProvider.getTransactionDao();
	}
	public boolean createDeposit(Deposit deposit) {
		return transactionDao.createDeposit(deposit);
	}

	public boolean createForeignTransfer(ForeignTransfer foreignTransfer) {
		return transactionDao.createForeignTransfer(foreignTransfer);
	}

	public boolean createDomesticTransfer(DomesticTransfer domesticTransfer) {
		return transactionDao.createDomesticTransfe(domesticTransfer);
	}

	public void confirmTransaction(Transaction transaction) {
		 transactionDao.confirmTransaction(transaction);
	}

	public void cancelTransaction(Transaction transaction) {
		 transactionDao.cancelTransaction(transaction);
		
	}
	
	public List<Transaction> getConfirmedTransactionList() {
		return transactionDao.getConfirmedTransactionList();
	}
}
