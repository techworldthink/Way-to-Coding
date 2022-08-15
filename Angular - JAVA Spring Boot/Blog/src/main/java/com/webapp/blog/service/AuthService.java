package com.webapp.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.blog.dto.RegisterRequest;
import com.webapp.blog.model.User;
import com.webapp.blog.repository.UserRepository;

@Service
public class AuthService {
	@Autowired
	private UserRepository userRepository;

	public void signup(RegisterRequest registerRequest) {
		User user = new User();
		user.setUserName(registerRequest.getUsername());
		user.setEmail(registerRequest.getEmail());
		user.setPassword(registerRequest.getPassword());

		userRepository.save(user);
	}

}
