package com.project.activity.client;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.project.activity.entity.Employee;
import com.project.activity.exception.EmployeeNotFoundException;

@FeignClient(url = "${employee.url}",name = "user-service")
public interface UserDetailsClient {

	@GetMapping(value = "/employee/getemployee/{id}")
	public Employee getEmployeeById(@PathVariable("id") int id,
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader)
			throws EmployeeNotFoundException;

}