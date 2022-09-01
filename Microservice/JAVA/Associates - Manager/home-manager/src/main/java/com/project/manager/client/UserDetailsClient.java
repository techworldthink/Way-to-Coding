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

@FeignClient(name = "user-service")
public interface UserDetailsClient {

	@GetMapping(value = "/employee/getemployee/{id}")
	public Employee getEmployeeById(@PathVariable("id") int id) throws EmployeeNotFoundException;

	@PostMapping(value = "/employee/addemployee")
	public Employee addEmployee(@RequestBody Employee employee);

	@GetMapping(value = "/employee/getemployee")
	public List<Employee> getEmployee() throws EmployeeEmptyException;

	@PutMapping("/employee/updateemp/{id}")
	public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee);

	@PutMapping("/employee/deleteemp/{id}")
	public Employee deleteEmployee(@PathVariable int id, @RequestBody boolean isDeleted);
}