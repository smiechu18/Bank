package pl.lodz.uni.math.banking.controller;

import java.util.List;

import pl.lodz.uni.math.banking.dao.UserDao;
import pl.lodz.uni.math.banking.engine.BinProvider;
import pl.lodz.uni.math.banking.pojo.Account;
import pl.lodz.uni.math.banking.pojo.User;

public class UserControllerImpl implements UserController {
	private UserDao userDao;
	private BinProvider binProvider;
	public UserControllerImpl() {
		binProvider = new BinProvider();
		userDao = binProvider.getUserDaoImpl();
	}

	public boolean createUser(User user) {
		return userDao.createUser(user);
	}

	public void deleteUser(User user) {
		userDao.deleteUser(user);
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public void deleteAccount(User user,Account account) {
		userDao.deleteAccount(user,account);
	}
	
	public boolean createAccount(User user, Account account) {
		return userDao.createAccount(user, account);
	}

	public User getUserById(String Id) {
		return userDao.getUserById(Id);
	}

	public Account getAccountByNumber(String string) {
		return userDao.getAccountByNumber(string);
	}

}
