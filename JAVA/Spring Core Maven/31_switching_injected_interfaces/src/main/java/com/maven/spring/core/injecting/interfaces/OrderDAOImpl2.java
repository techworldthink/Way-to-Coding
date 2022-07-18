package com.maven.spring.core.injecting.interfaces;

public class OrderDAOImpl2 implements OrderDAO {

	@Override
	public void createOrder() {
		System.out.println("Inside order DAO2 createOrder");

	}

}
