package com.learn.foodservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.foodservice.entity.Food;
import com.learn.foodservice.exception.FoodItemNotFoundException;
import com.learn.foodservice.repository.FoodRepository;


@Service
public class FoodService {
	
	@Autowired
	private FoodRepository foodRepository;

	public Food getFoodById(int id) throws FoodItemNotFoundException {
		Food food = foodRepository.findById(id).orElse(null);
		if (food != null)
			return food;
		else
			throw new FoodItemNotFoundException("Food Item not found");
	}

}
