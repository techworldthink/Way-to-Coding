package com.cognizant.Loan.model;

public class Loan {
	String number;
	String type;
	Double loanAmount;
	float emi;
	int tenure;
	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Loan(String number, String type, Double loanAmount, float emi, int tenure) {
		super();
		this.number = number;
		this.type = type;
		this.loanAmount = loanAmount;
		this.emi = emi;
		this.tenure = tenure;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public float getEmi() {
		return emi;
	}
	public void setEmi(float emi) {
		this.emi = emi;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	@Override
	public String toString() {
		return "Loan [number=" + number + ", type=" + type + ", loanAmount=" + loanAmount + ", emi=" + emi + ", tenure="
				+ tenure + "]";
	}
	
	
}
