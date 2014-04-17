package pl.lodz.uni.math.banking.dao;

import java.util.ArrayList;
import java.util.List;

import pl.lodz.uni.math.banking.pojo.*;

public class TransactionDaoMemImpl implements TransactionDao {
	private ArrayList<Transaction> transactions;

	public TransactionDaoMemImpl() {
		transactions = new ArrayList<Transaction>();
	}

	public boolean createTransaction(Transaction transaction) {
		return transactions.add(transaction);
	}

	public List<Transaction> getAllTransaction() {
		return transactions;
	}

	public void cancelTransaction(Transaction transaction) {
		if(transaction.getTransactionStatus() == EnumtransactionStatus.confirmed){
		}
		else
		{
			transaction.setTransactionStatus(EnumtransactionStatus.canceled);
		}
	}
	public void confirmTransaction(Transaction transaction) {
		if(transaction.getTransactionStatus() == EnumtransactionStatus.canceled){
		}
		else
		{
			transaction.setTransactionStatus(EnumtransactionStatus.confirmed);
		}
	}
	public List<Transaction> getTransfersToTheAccount(Account account) {
		List<Transaction> tmp = new ArrayList<Transaction>();
		for(Transaction t : transactions){
			if(t.getReceiverAccount().equals(account)){
				tmp.add(t);
			}
		}
		return tmp;
	}

}
