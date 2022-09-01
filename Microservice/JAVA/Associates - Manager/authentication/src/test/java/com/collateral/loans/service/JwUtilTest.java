package com.collateral.loans.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.project.authorization.dao.UserDAO;
import com.project.authorization.model.UserData;
import com.project.authorization.service.CustomerDetailsService;
import com.project.authorization.service.JwtUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@SpringBootTest
public class JwUtilTest {

	UserDetails userdetails;

	@InjectMocks
	JwtUtil jwtUtil;

	@Mock
	UserDAO userservice;
	
	@Mock
	CustomerDetailsService custdetailservice;

	@Test
	public void generateTokenTest() {
		String generateToken = jwtUtil.generateToken(userdetails);
		assertNotNull(generateToken);
	}

	@Test
	public void validateTokenTest() {
		userdetails = new User("admin", "admin", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userdetails);
		Boolean validateToken = jwtUtil.validateToken(generateToken);
		assertEquals(true, validateToken);
	}

	@Test
	public void validateTokenWithNameTest() {
		userdetails = new User("admin", "admin", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userdetails);
		Boolean validateToken = jwtUtil.validateToken(generateToken); //, userdetails);
		assertEquals(true, validateToken);
	}

	@Test
	public void validateTokenWithNameFalseTest() {
		userdetails = new User("admin", "admin", new ArrayList<>());
		UserDetails user1 = new User("admin1", "admin1", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userdetails);
		Boolean validateToken = jwtUtil.validateToken(generateToken); //, user1);
		assertEquals(false, validateToken);
	}
	
//	void loadUserByUserNameShouldThrowExceptionTest() {
//		when(userDao.findByUserName("wrongUserName")).thenReturn(null);
//		assertThatThrownBy(() -> service.loadUserByUsername("wrongUserName")) 
//        .isInstanceOf(UsernameNotFoundException.class)
//        .hasMessage("User not found with username: wrongUserName");
//		verify(userDao, Mockito.times(1)).findByUserName("wrongUserName");
//	}
	
	@Test
	void extractUserNameTest() {
//		when(jwtUtil.extractUsername("token")).thenReturn("username");

		assertThat(jwtUtil.extractUsername("token")).isNotNull();
	}

}
