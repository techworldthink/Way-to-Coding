package com.learn.api.angular.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

	@Autowired
	private UserRepository repository;

	@Override
	public void run(String... args) throws Exception { 
		repository.save(new Users(1, "A", "AA"));
		repository.save(new Users(2, "AB", "AA"));
		repository.save(new Users(3, "AC", "AA"));
		repository.save(new Users(4, "AD", "AA"));
	
		System.out.println(repository.findAll()); 

	}

}
