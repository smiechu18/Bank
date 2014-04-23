package pl.lodz.uni.math.banking.pojo;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

public class Account {
	private GregorianCalendar creatingDate;
	private String number;
	private GregorianCalendar closingDate;
	private String country;
	private BigDecimal balance;
	private String swift;
	private static int accountNumberCounter = 1000;

	public Account(String country, double balance) {
		this.setBalance(balance);
		this.closingDate = new GregorianCalendar();
		this.country = country;
		this.creatingDate = new GregorianCalendar();
		this.setNumber("00 5700 0000 " + accountNumberCounter);
		accountNumberCounter++;
		this.setSwift("ACCBTPLX");
	}

	public Account(String country, double balance, String swift) {
		this.setBalance(balance);
		this.closingDate = new GregorianCalendar();
		this.country = country;
		this.creatingDate = new GregorianCalendar();
		this.setNumber("00 5700 0000 " + accountNumberCounter);
		accountNumberCounter++;
		this.setSwift(swift);
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getSwift() {
		return swift;
	}

	public void setSwift(String swift) {
		this.swift = swift;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public void setBalance(double balance) {
		this.balance = new BigDecimal(balance);
	}

}
