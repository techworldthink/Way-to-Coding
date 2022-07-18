package com.maven.spring.core.injecting.interfaces;

import org.springframework.stereotype.Component;

@Component(value = "dao2")
public class OrderDAOImpl2 implements OrderDAO {

	@Override
	public void createOrder() {
		System.out.println("Inside order DAO2 createOrder");

	}

}
