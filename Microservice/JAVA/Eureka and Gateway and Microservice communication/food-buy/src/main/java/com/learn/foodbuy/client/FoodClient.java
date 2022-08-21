package com.learn.foodbuy.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.learn.foodbuy.entity.Food;
import com.learn.foodbuy.exception.FoodItemNotFoundException;




@FeignClient(url="${food.url}" , name="food-service")
public interface FoodClient {

	@GetMapping(value = "/getfood/{id}")
	public Food getFoodById(@PathVariable("id") int id) throws FoodItemNotFoundException;
}