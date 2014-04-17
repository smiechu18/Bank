package pl.lodz.uni.math.banking.engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import pl.lodz.uni.math.banking.dao.TransactionDao;
import pl.lodz.uni.math.banking.dao.UserDao;

public class BinProvider {
	private Scanner scanner;
	public BinProvider(){
		 try {
			scanner = new Scanner(new File("project.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 scanner.useDelimiter("=|\\s+");
	}

	public UserDao getUserDaoImpl() {
		String input = null;
		UserDao userDaoImplObj = null;
		while (scanner.hasNext()) {
			if (scanner.next().equals("UserDaoImpl")) {
				input = scanner.next();
				break;
			}
		}
		Class<?> userDaoImpl = null;
		Constructor<?> constructor = null;
		try {
			userDaoImpl = Class.forName(input);
			constructor = userDaoImpl.getConstructor();
			userDaoImplObj = (UserDao) constructor.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return userDaoImplObj;
	}

	public TransactionDao getTransactionDaoImpl() {
		String input = null;
		TransactionDao transactionDaoImplObj = null;
		while (scanner.hasNext()) {
			if (scanner.next().equals("TransactionDaoImpl")) {
				input = scanner.next();
				break;
			}
		}
		Class<?> transactionDaoImpl = null;
		Constructor<?> constructor = null;
		try {
			transactionDaoImpl = Class.forName(input);
			constructor = transactionDaoImpl.getConstructor();
			transactionDaoImplObj = (TransactionDao) constructor.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return transactionDaoImplObj;
	}

}
