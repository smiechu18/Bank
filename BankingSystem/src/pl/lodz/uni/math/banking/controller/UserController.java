package pl.lodz.uni.math.banking.controller;

import java.util.List;

import pl.lodz.uni.math.banking.pojo.Account;
import pl.lodz.uni.math.banking.pojo.User;

public interface UserController {
	
	boolean createUser(User user);

	List<User> getAllUsers();

	void deleteUser(User user);

	boolean createAccount(User user, Account account);

	void deleteAccount(User user,Account account);

	User getUserById(String Id);

	Account getAccountByNumber(String string);
	
	
}
