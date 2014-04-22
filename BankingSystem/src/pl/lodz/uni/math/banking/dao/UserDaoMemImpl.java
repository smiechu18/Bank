package pl.lodz.uni.math.banking.dao;

import java.util.HashSet;
import java.util.Set;

import pl.lodz.uni.math.banking.pojo.Account;
import pl.lodz.uni.math.banking.pojo.User;

public class UserDaoMemImpl implements UserDao {
	private Set<User> users;

	public UserDaoMemImpl() {
		users = new HashSet<>();
	}

	public boolean createUser(User user) {
		boolean tmp = false;
		for (User u : users) {
			if (u.getSsn().equals(user.getSsn())  	||	 u.getIdNumber().equals(user.getIdNumber())) {
				tmp = true;
			} else {
				tmp = false;
			}
		}
		if(!tmp){
			return users.add(user);
		}
		return false;
	}

	public Set<User> getAllUsers() {
		return users;
	}

	public boolean deleteUser(User user) {
		if(user == null){
			System.out.println("User not found");
			return false;
		}
		else  {
			return users.remove(user);
		}
		
	}

	public boolean createAccount(User user, Account account) {
		if(user == null){
			System.out.println("User not found");
			return false;
		}
		else if(account == null){
			System.out.println("Account not found");
			return false;
		}
		else  {
			return user.getAccountsList().add(account);
		}
		
	}

	public boolean deleteAccount(User user, Account account) {
		if(user == null){
			System.out.println("User not found");
			return false;
		}
		else{
			user.getClosedAccountsList().add(account);
			return user.getAccountsList().remove(account);
		} 
	}

	public User getUserById(String id) {
		User tmp = null;
		for (User u : users) {
			if (u.getIdNumber().equals(id)) {
				tmp = u;
			}
		}
		return tmp;
	}

	public Account getAccountByNumber(String string) {
		Account tmp = null;
		for (User u : users) {
			for (Account a : u.getAccountsList()) {
				if (a.getNumber().equals(string)) {
					tmp = a;
				}
			}
		}
		return tmp;
	}

	
}
