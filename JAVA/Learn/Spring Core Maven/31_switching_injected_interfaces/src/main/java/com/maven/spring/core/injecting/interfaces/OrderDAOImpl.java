package com.maven.spring.core.injecting.interfaces;

public class OrderDAOImpl implements OrderDAO {

	@Override
	public void createOrder() {
		System.out.println("Inside order DAO createOrder");

	}

}
