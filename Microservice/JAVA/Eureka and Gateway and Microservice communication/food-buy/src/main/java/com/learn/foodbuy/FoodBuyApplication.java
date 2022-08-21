package com.learn.foodbuy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableFeignClients
public class FoodBuyApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodBuyApplication.class, args);
	}

}
