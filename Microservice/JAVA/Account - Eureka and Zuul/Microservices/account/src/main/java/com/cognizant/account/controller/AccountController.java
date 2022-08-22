package com.cognizant.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.account.model.Account;
import com.cognizant.account.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping("/accounts")
	public List<Account> retrieveAcoounts() {
		return accountService.getAccounts();
	}
	
	
	@GetMapping("/accounts/{number}")
	public Account retrieveAcoountByAccountNumber(@PathVariable String number) {
		return accountService.getAccountByAccountNumber(number);
	}
	
}
