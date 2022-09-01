package com.collateral.loans.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.authorization.controller.AuthController;
import com.project.authorization.dao.UserDAO;
import com.project.authorization.model.AuthResponse;
import com.project.authorization.model.UserData;
import com.project.authorization.service.CustomerDetailsService;
import com.project.authorization.service.JwtUtil;

@SpringBootTest
public class AuthControllerTest {

	@InjectMocks
	AuthController authController;

	AuthResponse authResponse;

	UserDetails userdetails;

	@Mock
	JwtUtil jwtutil;

	@Mock
	CustomerDetailsService custdetailservice;

	@Mock
	UserDAO userservice;

	@Test
	public void loginTest() throws Exception {

		UserData user = new UserData("admin", "admin",null,null);
		UserDetails loadUserByUsername = custdetailservice.loadUserByUsername("admin");
		UserDetails value = new User(user.getUserid(), user.getUpassword(), new ArrayList<>());
		when(custdetailservice.loadUserByUsername("admin")).thenReturn(value);
		when(jwtutil.generateToken(loadUserByUsername)).thenReturn("token");
		ResponseEntity<?> login = authController.login(user);
		assertEquals(login.getStatusCodeValue(), 200);
	}

	@Test
	public void loginTestFailed() throws Exception {

		UserData user = new UserData("admin", "admin",null,null);
		UserDetails loadUserByUsername = custdetailservice.loadUserByUsername("admin");
		UserDetails value = new User(user.getUserid(), "admin11", new ArrayList<>());
		when(custdetailservice.loadUserByUsername("admin")).thenReturn(value);
		when(jwtutil.generateToken(loadUserByUsername)).thenReturn("token");
		ResponseEntity<?> login = authController.login(user);
		assertEquals(login.getStatusCodeValue(), 403);
	}

	@Test
	public void validateTestValidtoken() throws Exception {

		// when(authController.verifyToken("token")).thenReturn(new
		// AuthResponse("admin", "admin", true))
		when(jwtutil.validateToken("token")).thenReturn(true);
		when(jwtutil.extractUsername("token")).thenReturn("admin");
		UserData user1 = new UserData("admin", "admin", "admin",null);
		Optional<UserData> data = Optional.of(user1);
		when(userservice.findById("admin")).thenReturn(data);
		ResponseEntity<?> validity = authController.getValidity("bearer token");
		assertEquals(validity.getBody().toString().contains("true"), true);

	}

	@Test
	public void validateTestInValidtoken() throws Exception {

		// when(authController.verifyToken("token")).thenReturn(new
		// AuthResponse("admin", "admin", true))
		when(jwtutil.validateToken("token")).thenReturn(false);
		ResponseEntity<?> validity = authController.getValidity("bearer token");
		assertEquals(validity.getBody().toString().contains("false"), false);
	}

	@Test
	public void testhealth() {
		ResponseEntity<?> healthCheckup = authController.healthCheckup();
		assertEquals(healthCheckup.getStatusCodeValue(), 200);
		
	}

}
