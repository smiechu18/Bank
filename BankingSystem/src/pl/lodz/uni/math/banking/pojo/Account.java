package pl.lodz.uni.math.banking.pojo;

public class Account {
	private String creatingDate; // GregorianCalendar
	private String number;
	private String closingDate; // GregorianCalendar
	private String country;
	private double balance;
	private String swift;

	public Account(String creatingDate, String number, String closingDate,
			String country, double balance) {
		this.balance = balance;
		this.closingDate = closingDate;
		this.country = country;
		this.creatingDate = creatingDate;
		this.setNumber(number);
		this.swift = "";
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
