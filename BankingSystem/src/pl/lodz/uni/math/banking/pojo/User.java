package pl.lodz.uni.math.banking.pojo;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String name;
	private String surname;
	private String address;
	private String ssn; // numer pesel
	private String idNumber;
	private String mainAccountNumber;
	private List<Account> accountsList;

	public User(String name, String idNumber) {
		this.setName(name);
		this.setIdNumber(idNumber);
		setAccountsList(new ArrayList<Account>());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public List<Account> getAccountsList() {
		return accountsList;
	}

	public void setAccountsList(List<Account> accountsList) {
		this.accountsList = accountsList;
	}

}
