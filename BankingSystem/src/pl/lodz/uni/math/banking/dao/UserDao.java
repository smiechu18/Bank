package pl.lodz.uni.math.banking.dao;

import java.util.List;

import pl.lodz.uni.math.banking.pojo.Account;
import pl.lodz.uni.math.banking.pojo.User;

public interface UserDao {
	boolean createUser(User user);

	List<User> getAllUsers();

	void deleteUser(User user);

	boolean createAccount(User user, Account account);

	void deleteAccount(User user, Account account);

	User getUserById(String id);

	Account getAccountByNumber(String string);

}
