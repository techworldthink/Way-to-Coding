package com.maven.spring.core.injecting.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("bo")
public class OrderBoImpl implements OrderBo {

	@Autowired
	private OrderDAO dao;

	@Override
	public void placeOrder() {
		System.out.println("Inside order BO placeOrder");
		dao.createOrder();
	}

	public OrderDAO getDao() {
		return dao;
	}

	public void setDao(OrderDAO dao) {
		this.dao = dao;
	}

}
