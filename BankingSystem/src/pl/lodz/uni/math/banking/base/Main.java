package pl.lodz.uni.math.banking.base;

import java.util.GregorianCalendar;

import pl.lodz.uni.math.banking.controller.TransactionController;
import pl.lodz.uni.math.banking.controller.UserController;
import pl.lodz.uni.math.banking.engine.BinProvider;
import pl.lodz.uni.math.banking.pojo.*;

public class Main {
	public static void main(String[] args) {
		BinProvider binProvider = new BinProvider();
		UserController uc = binProvider.getUserController();
		TransactionController tc = binProvider.getTransactionController();
		
		User u = new User("adas", "1","ww");
		u.setAddress("ldz");
		uc.createUser(u);
	
		GregorianCalendar t1 = new GregorianCalendar();
		double k = 1.5;
		for(int i=5;i < 10000000;i++){
			
			k=k+0.15/i;
		}
		System.out.println(k);
		uc.createAccount(uc.getUserById("1"), new Account("country", 100));
		uc.createAccount(uc.getUserById("1"), new Account("country", 20,"dwdw"));
		tc.createDomesticTransfer(new DomesticTransfer(uc.getAccountByNumber("00 5700 0000 1000"), uc.getAccountByNumber("00 5700 0000 1001"), "title", 3));
		tc.confirmTransaction(tc.getWaitingTransactionByNumber(10001));
		tc.createDomesticTransfer(new DomesticTransfer(uc.getAccountByNumber("00 5700 0000 1000"), uc.getAccountByNumber("00 5700 0000 1001"), "title", 1));
		tc.confirmTransaction(tc.getWaitingTransactionByNumber(10002));
		tc.createDomesticTransfer(new DomesticTransfer(uc.getAccountByNumber("00 5700 0000 1001"), uc.getAccountByNumber("00 5700 0000 1000"), "title", 19));
		tc.confirmTransaction(tc.getWaitingTransactionByNumber(10003));
		//System.out.println(tc.getConfirmedTransactionList());
		double z = 1.5;
		for(int i=5;i < 10000000;i++){
			
			z=z+0.145/i;
		}
		
		GregorianCalendar t2 = new GregorianCalendar();
		tc.showAccountHistory(uc.getAccountByNumber("00 5700 0000 1000"), t1);
		tc.showAccountHistory(uc.getAccountByNumber("00 5700 0000 1001"), t2);
		//tc.showHistory(uc.getUserById("1"));
		
		
		
		
	}
}
