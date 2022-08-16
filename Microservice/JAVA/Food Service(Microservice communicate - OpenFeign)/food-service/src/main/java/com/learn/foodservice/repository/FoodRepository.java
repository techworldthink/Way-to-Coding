package com.learn.foodservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.foodservice.entity.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer>{

}
