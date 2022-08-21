package com.learn.foodbuy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.learn.foodbuy.client.FoodClient;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
	private DiscoveryClient discoveryClient;

	public Order addOrder(Order order) throws FoodItemNotFoundException, InvalidOrderException {
		List<ServiceInstance> instances = discoveryClient.getInstances("food-service");
		ServiceInstance serviceInstance = instances.get(0);
		String foodBaseUrl = serviceInstance.getUri().toString();

		foodBaseUrl = foodBaseUrl + "/getfood/" + order.getFoodId();
		RestTemplate restTemplate = new RestTemplate();

		try {
			Food food = restTemplate.getForObject(foodBaseUrl, Food.class);
			if (food.getAvailableCount() < order.getCount()) {
				throw new InvalidOrderException("Invalid Item count!");
			}
			int price = order.getCount() * food.getPrice();
			order.setTotal(price);
			order = orderRepository.save(order);
		} catch (Exception ex) {
			throw new InvalidOrderException(ex.getMessage());
		}

		return order;
	}

	public List<Order> viewOrder() {
		return orderRepository.findAll();
	}

}
