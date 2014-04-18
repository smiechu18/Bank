package pl.lodz.uni.math.banking.base;

import pl.lodz.uni.math.banking.controller.TransactionController;
import pl.lodz.uni.math.banking.controller.UserController;
import pl.lodz.uni.math.banking.engine.BinProvider;
import pl.lodz.uni.math.banking.pojo.Account;
import pl.lodz.uni.math.banking.pojo.User;

public class Main {
	public static void main(String[] args) {
		BinProvider binProvider = new BinProvider();
		UserController uc = binProvider.getUserController();
		TransactionController tc = binProvider.getTransactionController();
		
		User u = new User("adas", "1");
		u.setAddress("ldz");
		uc.createUser(u);
		System.out.println(uc.getAllUsers());
	}
}
