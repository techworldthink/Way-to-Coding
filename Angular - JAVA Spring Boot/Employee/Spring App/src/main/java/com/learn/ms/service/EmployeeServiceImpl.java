package com.learn.ms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.ms.entity.Employee;
import com.learn.ms.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee deleteEmployee(int id) {
		Employee emp = employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee with the id " + id + " does not exist"));
		employeeRepository.deleteById(id);
		return emp;
	}

	@Override
	public Employee updateEmployee(int id, Employee employee) {

		Optional<Employee> optEmp = employeeRepository.findById(id);
		if (!optEmp.isPresent()) {
			throw new RuntimeException("Employee with the id " + id + " does not exist");
		}

		Employee emp = optEmp.get();

		if (employee.getName() != null) {
			emp.setName(employee.getName());
		}
		if (employee.getGender() != null) {
			emp.setGender(employee.getGender());
		}
		if (employee.getAge() != 0) {
			emp.setAge(employee.getAge());
		}
		if (employee.getSalary() != 0) {
			emp.setSalary(employee.getSalary());
		}

		employeeRepository.save(emp);

		return emp;
	}

	@Override
	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee with the id " + id + " does not exist"));
	}

}
