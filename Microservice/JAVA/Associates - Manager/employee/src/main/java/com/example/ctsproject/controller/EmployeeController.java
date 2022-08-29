package com.example.ctsproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ctsproject.entity.Employee;
import com.example.ctsproject.exception.EmployeeEmptyException;
import com.example.ctsproject.exception.EmployeeNotFoundException;
import com.example.ctsproject.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping(value="/getemployee/{id}")
	public Employee getEmployeeById(@PathVariable("id") int id) throws EmployeeNotFoundException{
		return employeeService.getEmployeeById(id);
	}
	
	@PostMapping(value="/addemployee")
	public Employee addEmployee(@RequestBody Employee employee){
		return employeeService.addEmployee(employee);
	}
	
	@GetMapping(value="/getemployee")
	public List<Employee> getEmployee() throws EmployeeEmptyException{
		return employeeService.getEmployee();
	}
	
	@PutMapping("/updateemp/{id}")
	public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
		return employeeService.updateEmployee(id, employee);
	}
	
	@PutMapping("/deleteemp/{id}")
	public Employee deleteEmployee(@PathVariable int id, @RequestBody boolean isDeleted) throws Exception {
		return employeeService.deleteEmployee(id, isDeleted);
	}
	
}
