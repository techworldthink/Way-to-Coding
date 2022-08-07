package com.learn.api.angular.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learn.api.angular.jpa.UserRepository;
import com.learn.api.angular.jpa.Users;

@RestController
public class UserController {

	// standard constructors
	
	private final UserRepository userRepository;
	

	public UserController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
    @RequestMapping("/")
    public String home(){
        return "Hello World!";
    }
    
	
	@GetMapping("/users")
	public List<Users> getUsers() {
		return (List<Users>) userRepository.findAll();
	}

	@PostMapping("/users")
	void addUser(@RequestBody Users user) {
		userRepository.save(user);
	}
}
