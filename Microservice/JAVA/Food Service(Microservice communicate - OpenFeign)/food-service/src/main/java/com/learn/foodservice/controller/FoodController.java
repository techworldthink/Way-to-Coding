package com.learn.foodservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.learn.foodservice.entity.Food;
import com.learn.foodservice.exception.FoodItemNotFoundException;
import com.learn.foodservice.service.FoodService;

@RestController
public class FoodController {
	
	@Autowired
	private FoodService foodService;
	
	@GetMapping(value = "/getfood/{id}")
	public Food getFoodById(@PathVariable int id) throws FoodItemNotFoundException {
		return foodService.getFoodById(id);	
	}
}
