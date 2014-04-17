package pl.lodz.uni.math.banking.dao;

import java.util.ArrayList;
import java.util.List;

import pl.lodz.uni.math.banking.pojo.Account;
import pl.lodz.uni.math.banking.pojo.User;

public class UserDaoMemImpl implements UserDao {
	private List<User> users;

	public UserDaoMemImpl() {
		users = new ArrayList<User>();
	}

	public boolean createUser(User user) {
		return users.add(user);
	}

	public List<User> getAllUsers() {
		return users;
	}

	public void deleteUser(User user) {
		users.remove(user);
	}

	@Override
	public boolean createAccount(User user, Account account) {
		return user.getAccountsList().add(account);
	}

	@Override
	public void deleteAccount(User user, Account account) {
		user.getAccountsList().remove(account);
		
	}

	public User getUserById(String id) {
		User tmp = null;
		for(User u : users){
			if(u.getIdNumber().equals(id)){
				tmp = u;
			}
		}
		return tmp;
	}

	public Account getAccountByNumber(String string) {
		Account tmp = null;
		for (User u : users){
			for (Account a : u.getAccountsList()){
				if(a.getNumber().equals(string)){
					tmp = a;
				}
			}
		}
		return tmp;
	}

	
}
