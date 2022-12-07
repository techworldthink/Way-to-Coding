package com.maven.spring.autowiring.annotations;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee {
	
	private Address address;
	
	@Autowired
	public Employee(Address address) {
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Employee [address=" + address + "]";
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}

}
