package com.example.ctsproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmployeeMain {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMain.class, args);
	}

}
