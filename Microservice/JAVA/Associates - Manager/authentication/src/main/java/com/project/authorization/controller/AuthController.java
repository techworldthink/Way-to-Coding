package com.project.authorization.controller;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.authorization.dao.UserDAO;
import com.project.authorization.exception.AuthenticationException;
import com.project.authorization.exception.AuthorizationException;
import com.project.authorization.model.AuthResponse;
import com.project.authorization.model.UserData;
import com.project.authorization.service.CustomerDetailsService;
import com.project.authorization.service.JwtUtil;

@RestController
@CrossOrigin
public class AuthController {

	@Autowired
	private JwtUtil jwtutil;

	@Autowired
	private CustomerDetailsService custdetailservice;

	@Autowired
	private UserDAO userservice;

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

	@RequestMapping(path = "/health", method = RequestMethod.GET)
	public ResponseEntity<?> healthCheckup() {
		LOGGER.info("AWS Health Check ");
		return new ResponseEntity<>("ok", HttpStatus.OK);
	}

	@PostMapping(value = "/login")
	public ResponseEntity<UserData> login(@RequestBody UserData userlogincredentials) throws AuthenticationException {
		final UserDetails userdetails = custdetailservice.loadUserByUsername(userlogincredentials.getUserid());
		String uid = "";
		String token = "";
		if (userdetails.getPassword().equals(userlogincredentials.getUpassword())) {
			uid = userlogincredentials.getUserid();
			token = jwtutil.generateToken(userdetails);

			UserData userData = new UserData(uid, null, null, token);
			userData.setAuthRole(jwtutil.extractRole(token));
			return new ResponseEntity<UserData>(userData, HttpStatus.OK);
		} else {
			LOGGER.info("At Login : ");
			LOGGER.error("Not Accesible");
			throw new AuthenticationException("Credentials invalid");
		}
	}

	@GetMapping(value = "/validate")
	public ResponseEntity<AuthResponse> getValidity(@RequestHeader("Authorization") final String token)
			throws AuthorizationException {
		String token1 = token.substring(7);
		AuthResponse res = new AuthResponse();
		if (jwtutil.validateToken(token1)) {
			res.setUid(jwtutil.extractUsername(token1));
			res.setValid(true);
			res.setName(userservice.findById(jwtutil.extractUsername(token1)).get().getUname());
			res.setRole(jwtutil.extractRole(token1));
			return new ResponseEntity<AuthResponse>(res, HttpStatus.OK);
		} else {
			LOGGER.info("At Validity : ");
			LOGGER.error("Token Has Expired");
			throw new AuthorizationException("Token invalid");
		}

//		AuthResponse res = new AuthResponse();
//		res.setUid("sample");
//		res.setValid(true);
//		res.setName("sample");
//		res.setRole("admin");
//		return new ResponseEntity<AuthResponse>(res, HttpStatus.OK);

	}

}
