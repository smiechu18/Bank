package pl.lodz.uni.math.banking.base;

import pl.lodz.uni.math.banking.controller.TransactionController;
import pl.lodz.uni.math.banking.controller.UserController;
import pl.lodz.uni.math.banking.engine.BinProvider;
import pl.lodz.uni.math.banking.pojo.Account;
import pl.lodz.uni.math.banking.pojo.Deposit;
import pl.lodz.uni.math.banking.pojo.DomesticTransfer;
import pl.lodz.uni.math.banking.pojo.ForeignTransfer;
import pl.lodz.uni.math.banking.pojo.User;

public class Main {
	public static void main(String[] args) {
		BinProvider binProvider = new BinProvider();
		UserController uc = binProvider.getUserController();
		TransactionController tc = binProvider.getTransactionController();
		
		User u = new User("adas", "1","ww");
		u.setAddress("ldz");
		uc.createUser(u);
	

		uc.createAccount(uc.getUserById("1"), new Account("creatingDate", "closingDate", "country", 100));
		uc.createAccount(uc.getUserById("1"), new Account("creatingDate", "closingDate", "country", 100,"dwdw"));
		System.out.println(uc.getAccountByNumber("00 5700 0000 1000"));
		System.out.println(uc.getAccountByNumber("00 5700 0000 1001"));
		
		tc.createDomesticTransfer(new DomesticTransfer(uc.getAccountByNumber("00 5700 0000 1000"), uc.getAccountByNumber("00 5700 0000 1001"), "titl", 3));
		tc.createForeignTransfer(new ForeignTransfer(uc.getAccountByNumber("00 5700 0000 1000"), uc.getAccountByNumber("00 5700 0000 1001"), "title", 4));
		System.out.println(tc.getWaitingTransactionByNumber(10001));
		tc.confirmTransaction(tc.getWaitingTransactionByNumber(10001));
		System.out.println(tc.getConfirmedTransactionList());
		tc.cancelTransaction(tc.getWaitingTransactionByNumber(2));
		System.out.println(tc.getCanceledTransactionList());
		
		
	}
}
