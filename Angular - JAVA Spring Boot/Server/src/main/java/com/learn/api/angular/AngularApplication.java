package com.learn.api.angular;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.learn.api.angular.jpa.UserRepository;
import com.learn.api.angular.jpa.Users;

@SpringBootApplication
public class AngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngularApplication.class, args);
	}
}
