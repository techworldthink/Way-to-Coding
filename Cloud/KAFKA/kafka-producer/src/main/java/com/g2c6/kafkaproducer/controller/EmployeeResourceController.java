package com.g2c6.kafkaproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g2c6.kafkaproducer.employee.Employee;
import com.g2c6.kafkaproducer.repository.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeResourceController {

	@Autowired
	private KafkaTemplate<String, Employee> kafkaTemplate;

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/{id}")
	public Employee getEmployees(@PathVariable int id) {
		kafkaTemplate.send("first-topic", employeeRepository.findById(id).get());
		return employeeRepository.findById(id).get();

	}
}
