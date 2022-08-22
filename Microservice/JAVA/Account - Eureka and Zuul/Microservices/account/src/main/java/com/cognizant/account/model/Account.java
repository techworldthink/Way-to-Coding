package com.cognizant.account.model;

public class Account {

	String accountNumber;
	String type;
	Double balance;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String accountNumber, String type, Double balance) {
		super();
		this.accountNumber = accountNumber;
		this.type = type;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", type=" + type + ", balance=" + balance + "]";
	}

}
