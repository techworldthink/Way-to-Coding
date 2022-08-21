package com.learn.foodbuy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.foodbuy.entity.Order;
import com.learn.foodbuy.exception.FoodItemNotFoundException;
import com.learn.foodbuy.exception.InvalidOrderException;
import com.learn.foodbuy.service.OrderService;

@RestController
public class BuyController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping(value = "/addorder")
	public Order addOrder(@RequestBody Order order) throws FoodItemNotFoundException, InvalidOrderException {
		return orderService.addOrder(order);		
	}
	
	@GetMapping(value = "/view")
	public List<Order> viewOrder() {
		return orderService.viewOrder();		
	}
}
