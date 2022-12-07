package com.learn.sql.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.sql.model.Employee;

@RestController
@RequestMapping("/api/methods")
public class SqlByMethod {

	@GetMapping("/add-employees")
	public List<Employee> addEmployee() {
		
		return null;

	}
}
