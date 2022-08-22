package com.cognizant.Loan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.Loan.model.Loan;

@Service
public class LoanService {

	List<Loan> loans;

	public LoanService() {

		loans = new ArrayList<>();
		loans.add(new Loan("H00987987972342", "car", 400000.0d, 3528, 18));
		loans.add(new Loan("H00914842545487", "bike", 400000.0d, 5689, 12));
		loans.add(new Loan("H00478215476824", "house", 400000.0d, 4587, 12));
		loans.add(new Loan("H00944879651684", "education", 400000.0d, 1234, 24));
	}

	public List<Loan> getAllLoans() {
		return loans;
	}

	public Loan getLoanByLoanNumber(String number) {
		for (Loan loan : loans) {
			if (loan.getNumber().equalsIgnoreCase(number)) {
				return loan;
			}
		}
		return null;
	}

}
