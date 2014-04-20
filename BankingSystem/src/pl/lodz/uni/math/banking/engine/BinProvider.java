package pl.lodz.uni.math.banking.engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import pl.lodz.uni.math.banking.controller.TransactionController;
import pl.lodz.uni.math.banking.controller.UserController;
import pl.lodz.uni.math.banking.dao.TransactionDao;
import pl.lodz.uni.math.banking.dao.UserDao;

public class BinProvider {
	
	private Scanner scanner;
	private Map<String, Class<?>> beans;
	
	public BinProvider(){
		 try {
			scanner = new Scanner(new File("project.properties"));
			scanner.useDelimiter("=|\\s+");
			readAllBeans();
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private <T> T newInstance(Class<T> clazz) {
		try {
			return clazz.getConstructor().newInstance();
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void readAllBeans() {
		beans = new HashMap<>();
		while (scanner.hasNext()) {
			String className = scanner.next();
			String classQualifiedName = scanner.next();
			Class<?> clazz = null;
			try {
				clazz = Class.forName(classQualifiedName);
				//check if a class has suitable contructor
				clazz.getConstructor();
				
				//add class to known class set
				beans.put(className, clazz);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		}
	}
	
	public UserDao getUserDao() {
		return (UserDao) newInstance(beans.get("UserDao"));
	}
	
	public TransactionDao getTransactionDao() {
		return (TransactionDao) newInstance(beans.get("TransactionDao"));
	}

	public UserController getUserController() {
		return (UserController) newInstance(beans.get("UserController"));
	}

	public TransactionController getTransactionController() {
		return (TransactionController) newInstance(beans.get("TransactionController"));
	}
}
