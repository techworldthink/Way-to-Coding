package com.learn.ms.control;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.learn.ms.entity.Employee;
import com.learn.ms.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;

	@GetMapping(value = "/getemployee/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable("id") int id) {
		return repository.findById(id);
	}
}
