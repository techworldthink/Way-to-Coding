package com.example.ctsproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ctsproject.entity.Employee;
import com.example.ctsproject.exception.EmployeeEmptyException;
import com.example.ctsproject.exception.EmployeeNotFoundException;
import com.example.ctsproject.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee getEmployeeById(int id) throws EmployeeNotFoundException{
		Employee employee = employeeRepository.findById(id).orElse(null);
		if(employee!=null && employee.isDeleted()==false)
			return employee;
		else
			throw new EmployeeNotFoundException("Employee is not found");
	}
	
	public Employee addEmployee(Employee employee){
		return employeeRepository.save(employee);
	}
	
	public List<Employee> getEmployee() throws EmployeeEmptyException{
		List<Employee> list = employeeRepository.findAll(); 
		if(!list.isEmpty())
			return list;
		else
			throw new EmployeeEmptyException("There is No Employee Data");
	}
	
	public Employee deleteEmployee(int id, boolean isDeleted) throws Exception {
		Optional<Employee> optEmp = employeeRepository.findById(id);
		if (!optEmp.isPresent()) {
			throw new Exception("EmployeeMain with the id " + id + " does not exist");
		}
		else{
			Employee emp = optEmp.get();
			emp.setDeleted(true);
			employeeRepository.save(emp);
			return emp;
		}
	}
	
	public Employee updateEmployee(int id, Employee employee) {

		Optional<Employee> optEmp = employeeRepository.findById(id);
		if (!optEmp.isPresent()) {
			throw new RuntimeException("EmployeeMain with the id " + id + " does not exist");
		}

		Employee emp = optEmp.get();

		if (employee.getFirstName() != null) {
			emp.setFirstName(employee.getFirstName());
		}
		if (employee.getLastName() != null) {
			emp.setLastName(employee.getLastName());
		}
		if (employee.getEmail() != null) {
			emp.setEmail(employee.getEmail());
		}
		if (employee.getJoinDate() != null) {
			emp.setJoinDate(employee.getJoinDate());
		}
		if (employee.getEndDate() != null) {
			emp.setEndDate(employee.getEndDate());
		}
		if (employee.getRole() != null) {
			emp.setRole(employee.getRole());
		}
		if (employee.getMentorName() != null) {
			emp.setMentorName(employee.getMentorName());
		}
		if (employee.isHomeManager() != true) {
			emp.setHomeManager(employee.isHomeManager());
		}
		if (employee.isStatus() != true) {
			emp.setStatus(employee.isStatus());
		}
		if (employee.isDeleted() != false) {
			emp.setDeleted(employee.isDeleted());
		}

		employeeRepository.save(emp);

		return emp;
	}
}
