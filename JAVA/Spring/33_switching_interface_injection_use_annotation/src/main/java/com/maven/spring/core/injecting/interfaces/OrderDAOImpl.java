package com.maven.spring.core.injecting.interfaces;

import org.springframework.stereotype.Component;

@Component(value = "dao")
public class OrderDAOImpl implements OrderDAO {

	@Override
	public void createOrder() {
		System.out.println("Inside order DAO createOrder");

	}

}
