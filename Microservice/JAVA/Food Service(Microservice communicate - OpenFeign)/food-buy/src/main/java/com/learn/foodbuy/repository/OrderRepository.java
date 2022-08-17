package com.learn.foodbuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.foodbuy.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
