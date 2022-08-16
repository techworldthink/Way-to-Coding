package com.example.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Demorestforcohort6Application {

	public static void main(String[] args) {
		SpringApplication.run(Demorestforcohort6Application.class, args);
	}

}
