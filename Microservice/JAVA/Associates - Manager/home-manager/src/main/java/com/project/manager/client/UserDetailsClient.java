package com.project.manager.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.manager.entity.Employee;
import com.project.manager.exception.EmployeeEmptyException;
import com.project.manager.exception.EmployeeNotFoundException;

@FeignClient(url = "${userdetails.url}", name = "employee-manage-service")
public interface UserDetailsClient {

	@GetMapping(value = "/getemployee/{id}")
	public Employee getEmployeeById(@PathVariable("id") int id) throws EmployeeNotFoundException;

	@PostMapping(value = "/addemployee")
	public Employee addEmployee(@RequestBody Employee employee);

	@GetMapping(value = "/getemployee")
	public List<Employee> getEmployee() throws EmployeeEmptyException;

	@PutMapping("/updateemp/{id}")
	public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee);

	@PutMapping("/deleteemp/{id}")
	public Employee deleteEmployee(@PathVariable int id, @RequestBody boolean isDeleted);
}