package com.learn.ms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.ms.entity.Employee;


public interface EmployeeService {

	List<Employee> getEmployees();

	Employee addEmployee(Employee employee);

	Employee deleteEmployee(int id);

	Employee updateEmployee(int id, Employee employee);

	Employee getEmployeeById(int id);
}
