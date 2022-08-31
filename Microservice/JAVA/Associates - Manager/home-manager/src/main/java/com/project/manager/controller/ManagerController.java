package com.project.manager.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.manager.client.AuthenticationClient;
import com.project.manager.entity.AuthResponse;
import com.project.manager.entity.Employee;
import com.project.manager.exception.AuthorizationException;
import com.project.manager.service.ManagerService;

@RestController
@RequestMapping("/managers")
public class ManagerController {

	@Autowired
	private ManagerService managerService;

	@Autowired
	AuthenticationClient authorisingClient;

	public boolean checkAuthentication(String requestTokenHeader) throws Exception {
		ResponseEntity<AuthResponse> valid = authorisingClient.getValidity(requestTokenHeader);
		return valid.getBody().isValid();

	}

	@GetMapping("/view/all")
	public List<Employee> getAllManagers(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws Exception {

		if (checkAuthentication(requestTokenHeader)) {
			return managerService.getAllManagers();
		} else {
			throw new AuthorizationException("Invalid token");
		}

	}

	@GetMapping("/view/{id}")
	public Employee getManagerById(@PathVariable("id") int id,
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws Exception {

		if (checkAuthentication(requestTokenHeader)) {
			return managerService.getManagerById(id);
		} else {
			throw new AuthorizationException("Invalid token");
		}
	}

	@DeleteMapping("/delete/{id}")
	public Employee deleteManagerById(@PathVariable("id") int id,
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws Exception {

		if (checkAuthentication(requestTokenHeader)) {
			return managerService.deleteManagerById(id);
		} else {
			throw new AuthorizationException("Invalid token");
		}
	}

	@PostMapping("/add")
	public Employee addManager(@RequestBody Employee homeManager,
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws Exception {

		if (checkAuthentication(requestTokenHeader)) {
			return managerService.addManager(homeManager);
		} else {
			throw new AuthorizationException("Invalid token");
		}
	}

	@PutMapping("/update/{id}")
	public Employee updateManager(@PathVariable("id") int id, @RequestBody Employee homeManager,
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws Exception {

		if (checkAuthentication(requestTokenHeader)) {
			return managerService.updateManager(id, homeManager);
		} else {
			throw new AuthorizationException("Invalid token");
		}
	}

}
