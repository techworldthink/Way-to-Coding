package com.maven.spring.core.injecting.interfaces;

public class OrderBoImpl implements OrderBo {

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
