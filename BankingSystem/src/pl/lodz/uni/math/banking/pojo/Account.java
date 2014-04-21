package pl.lodz.uni.math.banking.pojo;

public class Account {
	private String creatingDate; // GregorianCalendar
	private String number;
	private String closingDate; // GregorianCalendar
	private String country;
	private double balance;
	private String swift;
	private static int accountNumberCounter = 1000;
	public Account(String creatingDate, String closingDate, String country,
			double balance) {
		this.setBalance(balance);
		this.closingDate = closingDate;
		this.country = country;
		this.creatingDate = creatingDate;
		this.setNumber("00 5700 0000 "+ accountNumberCounter);
		accountNumberCounter++;
		this.setSwift("ACCBTPLX");
	}
	public Account(String creatingDate, String closingDate, String country,
			double balance,String swift) {
		this.setBalance(balance);
		this.closingDate = closingDate;
		this.country = country;
		this.creatingDate = creatingDate;
		this.setNumber("00 5700 0000 "+ accountNumberCounter);
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

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
