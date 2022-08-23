package com.task.dynamodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.dynamodb.model.Employee;
import com.task.dynamodb.repository.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeResource {
	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeRepository.addEmployee(employee);
	}

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeRepository.findEmployeeById(id);
	}

	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return employeeRepository.deleteEmployee(id);
	}

	@PutMapping
	public String updateEmployee(@RequestBody Employee employee) {
		return employeeRepository.editEmployee(employee);
	}
}
