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
	private Map<String, Constructor<?>> beans;
	
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

	private Object createNewInstance(String className) {
		try {
			return beans.get(className).newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
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
			Constructor<?> constructor = null;
			try {
				clazz = Class.forName(classQualifiedName);
				constructor = clazz.getConstructor();
				beans.put(className, constructor);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Object getBeanByName(String className) {
		return createNewInstance(className);
	}

	public UserDao getUserDao() {
		return (UserDao) createNewInstance("UserDao");
	}
	
	public TransactionDao getTransactionDao() {
		return (TransactionDao) createNewInstance("TransactionDao");
	}

	public UserController getUserController() {
		return (UserController) createNewInstance("UserController");
	}

	public TransactionController getTransactionController() {
		return (TransactionController) createNewInstance("TransactionController");
	}
}
