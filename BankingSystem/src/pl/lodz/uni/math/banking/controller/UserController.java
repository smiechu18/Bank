package pl.lodz.uni.math.banking.controller;

import java.util.Set;

import pl.lodz.uni.math.banking.pojo.Account;
import pl.lodz.uni.math.banking.pojo.User;

public interface UserController {
	
	void createUser(User user);

	Set<User> getAllUsers();

	void deleteUser(User user);

	void createAccount(User user, Account account);

	void deleteAccount(User user,Account account);

	User getUserById(String Id);

	Account getAccountByNumber(String string);
		
}
