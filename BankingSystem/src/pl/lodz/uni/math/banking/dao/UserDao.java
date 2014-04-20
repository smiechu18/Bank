package pl.lodz.uni.math.banking.dao;

import java.util.Set;

import pl.lodz.uni.math.banking.pojo.Account;
import pl.lodz.uni.math.banking.pojo.User;

public interface UserDao {
	boolean createUser(User user);

	Set<User> getAllUsers();

	boolean deleteUser(User user);

	boolean createAccount(User user, Account account);

	boolean deleteAccount(User user, Account account);

	User getUserById(String id);

	Account getAccountByNumber(String string);

}
