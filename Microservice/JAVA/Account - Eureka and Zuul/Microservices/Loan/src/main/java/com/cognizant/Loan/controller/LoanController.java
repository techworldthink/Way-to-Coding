package com.cognizant.Loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Loan.model.Loan;
import com.cognizant.Loan.service.LoanService;

@RestController
public class LoanController {

	@Autowired
	private LoanService loanService;

	@GetMapping("/loans")
	public List<Loan> retrieveAllLoans() {
		return loanService.getAllLoans();
	}

	@GetMapping("/loans/{number}")
	public Loan retrieveLoanByNumber(@PathVariable String number) {
		return loanService.getLoanByLoanNumber(number);
	}
}
