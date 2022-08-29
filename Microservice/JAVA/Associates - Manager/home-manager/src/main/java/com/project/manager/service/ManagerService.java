package com.project.manager.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.manager.client.UserDetailsClient;
import com.project.manager.entity.Employee;
import com.project.manager.exception.EmployeeEmptyException;
import com.project.manager.exception.ManagerNotFoundException;

@Service
public class ManagerService {

	@Autowired
	private UserDetailsClient userDetailsClient;

	public List<Employee> getAllManagers() throws EmployeeEmptyException {
		return userDetailsClient.getEmployee();
	}

	public Employee getManagerById(int id) throws Exception {
		return userDetailsClient.getEmployeeById(id);
	}

	public Employee deleteManagerById(int id) throws ManagerNotFoundException {
		return userDetailsClient.deleteEmployee(id, true);
	}

	public Employee addManager(Employee homeManager) throws Exception {
		return userDetailsClient.addEmployee(homeManager);
	}

	public Employee updateManager(int id, Employee homeManager) throws Exception {
		return userDetailsClient.updateEmployee(id, homeManager);
	}
}
