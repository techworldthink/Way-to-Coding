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

	private static final String TOPIC = "first-topic";

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/{id}")
	//http://localhost:8080/employees/101
	public Employee getEmployees(@PathVariable int id) {
		Employee employee = employeeRepository.findById(id).get();
		System.out.println(employee.getId());
		kafkaTemplate.send(TOPIC, employee);
		return employee;
	}
}
