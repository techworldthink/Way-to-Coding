package com.example.ctsproject.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.ctsproject.entity.Employee;
import com.example.ctsproject.service.EmployeeService;
import com.example.ctsproject.client.AuthClient;
import com.example.ctsproject.entity.AuthResponse;
import com.example.ctsproject.exception.AuthorizationException;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@Autowired
	AuthClient authClient;

	
	public boolean checkAuthentication(String requestTokenHeader) throws Exception {
		ResponseEntity<AuthResponse> valid = authClient.getValidity(requestTokenHeader);
		return valid.getBody().isValid();
	}
		
	@GetMapping("/getemployee/{id}")
	public Employee getEmployeeById(@PathVariable("id") int id,
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws Exception {

		if (checkAuthentication(requestTokenHeader)) {
			return employeeService.getEmployeeById(id);
		} else {
			throw new AuthorizationException("Invalid token");
		}
	}
	
	@PostMapping("/addemployee")
	public Employee addEmployee(@RequestBody Employee employee,
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws Exception {

		if (checkAuthentication(requestTokenHeader)) {
			return employeeService.addEmployee(employee);
		} else {
			throw new AuthorizationException("Invalid token");
		}
	}
	
	@GetMapping("/getemployee")
	public List<Employee> getEmployee(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws Exception {

		if (checkAuthentication(requestTokenHeader)) {
			return employeeService.getEmployee();
		} else {
			throw new AuthorizationException("Invalid token");
		}

	}
	
	@PutMapping("/updateemp/{id}")
	public Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee,
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws Exception {

		if (checkAuthentication(requestTokenHeader)) {
			return employeeService.updateEmployee(id, employee);
		} else {
			throw new AuthorizationException("Invalid token");
		}
	}
	
	
	@DeleteMapping("/deleteemp/{id}")
	public Employee deleteEmployee(@PathVariable("id") int id, @RequestBody boolean isDeleted,
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws Exception {

		if (checkAuthentication(requestTokenHeader)) {
			return employeeService.deleteEmployee(id, isDeleted);
		} else {
			throw new AuthorizationException("Invalid token");
		}
	}
}
