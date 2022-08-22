package com.cognizant.account.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.account.model.Account;

@Service
public class AccountService {
	
	private List<Account> accounts;
	
	public AccountService() {
		accounts = new ArrayList<>();
		
		accounts.add(new Account("ACSD000015964", "Savings", 20000.0d));
		accounts.add(new Account("ACSD000015946", "Current", 10000.0d));
		accounts.add(new Account("ACSD000015978", "Current", 24000.0d));
		accounts.add(new Account("ACSD000015931", "Savings", 80000.0d));
		
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}
	
	public Account getAccountByAccountNumber(String accountNumber) {
		
		for(Account account: accounts) {
			if (account.getAccountNumber().equalsIgnoreCase(accountNumber)){
				return account;
			}
		}
		return null;
	}
	
}
