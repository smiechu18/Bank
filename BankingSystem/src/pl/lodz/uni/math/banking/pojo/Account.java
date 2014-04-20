package pl.lodz.uni.math.banking.pojo;

public class Account {
	private String creatingDate; // GregorianCalendar
	private String number;
	private String closingDate; // GregorianCalendar
	private String country;
	private double balance;
	private String swift;

	public Account(String creatingDate, String closingDate, String country,
			double balance) {
		this.setBalance(balance);
		this.closingDate = closingDate;
		this.country = country;
		this.creatingDate = creatingDate;
		this.setNumber(number);
		this.setSwift("");
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
