package com.learn.foodbuy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.foodbuy.client.FoodClient;
import com.learn.foodbuy.entity.Food;
import com.learn.foodbuy.entity.Order;
import com.learn.foodbuy.exception.FoodItemNotFoundException;
import com.learn.foodbuy.exception.InvalidOrderException;
import com.learn.foodbuy.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private FoodClient foodclient;
	
	
	public Order addOrder(Order order) throws FoodItemNotFoundException, InvalidOrderException {
		Food food = foodclient.getFoodById(order.getFoodId());
		if(food.getAvailableCount() < order.getCount()) {
			throw new InvalidOrderException("Invalid Item count!");
		}
		int price = order.getCount() * food.getPrice();
		order.setTotal(price);
		order = orderRepository.save(order);
		return order;
	}

}
