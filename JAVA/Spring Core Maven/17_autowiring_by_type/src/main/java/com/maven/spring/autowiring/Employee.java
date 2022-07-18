package com.maven.spring.autowiring;

public class Employee {

	private Address address;

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
