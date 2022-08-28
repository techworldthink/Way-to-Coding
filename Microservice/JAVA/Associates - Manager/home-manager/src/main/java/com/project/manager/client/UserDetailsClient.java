package com.project.manager.client;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.manager.entity.Employee;
import com.project.manager.exception.EmployeeNotFoundException;

@FeignClient(url = "${userdetails.url}", name = "employee-manage-service")
public interface UserDetailsClient {

	@GetMapping(value = "/getemployee/{id}")
	public Employee getEmployeeById(@PathVariable("id") int id) throws EmployeeNotFoundException;
}