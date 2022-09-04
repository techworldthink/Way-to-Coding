package com.project.manager.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.manager.client.UserDetailsClient;
import com.project.manager.entity.Employee;
import com.project.manager.exception.EmployeeEmptyException;
import com.project.manager.exception.EmployeeNotFoundException;
import com.project.manager.exception.ManagerNotFoundException;
import com.project.manager.validator.ManagerValidator;

@Service
public class ManagerService {

	@Autowired
	private UserDetailsClient userDetailsClient;

	@Autowired
	private ManagerValidator managerValidator;

	private void validateHomeManager(Employee homeManager) throws Exception {
		managerValidator.validateNotNull(homeManager.getFirstName());
		managerValidator.validateNotNull(homeManager.getJoinDate());
		managerValidator.validateNotNull(homeManager.getRole());
		managerValidator.validateNotNull(homeManager.getLastName());
		managerValidator.validateFirstName(homeManager.getFirstName());
		managerValidator.validateEmail(homeManager.getEmail());
	}

	private void isHomeManager(int id, String token) throws ManagerNotFoundException, EmployeeNotFoundException {
		Employee manager = userDetailsClient.getEmployeeById(id, token);
		if (!manager.isHomeManager())
			throw new ManagerNotFoundException("Manager not found");
	}

	
	
	public List<Employee> getAllManagers(String token) throws Exception {
		return userDetailsClient.getHomeManagers(token);
	}

	public Employee getManagerById(int id, String token) throws Exception {
		isHomeManager(id, token);
		Employee manager = userDetailsClient.getEmployeeById(id, token);
		return manager;
	}

	public Employee deleteManagerById(int id, String token) throws ManagerNotFoundException, EmployeeNotFoundException {
		isHomeManager(id, token);
		return userDetailsClient.deleteEmployee(id, true, token);
	}

	public Employee addManager(Employee homeManager, String token) throws Exception {
		validateHomeManager(homeManager);
		homeManager.setHomeManager(true);
		return userDetailsClient.addEmployee(homeManager, token);
	}

	public Employee updateManager(int id, Employee homeManager, String token) throws Exception {
		isHomeManager(id, token);
		validateHomeManager(homeManager);
		return userDetailsClient.updateEmployee(id, homeManager, token);

	}
}
