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

	/**
	 * 
	 * @param homeManager
	 * @throws Exception
	 */
	private void validateHomeManager(Employee homeManager) throws Exception {
		managerValidator.validateNotNull(homeManager.getFirstName());
		managerValidator.validateNotNull(homeManager.getJoinDate());
		managerValidator.validateNotNull(homeManager.getRole());
		managerValidator.validateNotNull(homeManager.getLastName());
		managerValidator.validateFirstName(homeManager.getFirstName());
		managerValidator.validateEmail(homeManager.getEmail());
	}

	/**
	 * 
	 * @param id
	 * @param token
	 * @throws ManagerNotFoundException
	 * @throws EmployeeNotFoundException
	 */
	private void isHomeManager(int id, String token) throws ManagerNotFoundException, EmployeeNotFoundException {
		Employee manager = userDetailsClient.getEmployeeById(id, token);
		if (!manager.isHomeManager())
			throw new ManagerNotFoundException("Manager not found");
	}

	/**
	 * 
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public List<Employee> getAllManagers(String token) throws Exception {
		return userDetailsClient.getHomeManagers(token);
	}

	/**
	 * 
	 * @param id
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public Employee getManagerById(int id, String token) throws Exception {
		isHomeManager(id, token);
		Employee manager = userDetailsClient.getEmployeeById(id, token);
		return manager;
	}

	/**
	 * 
	 * @param id
	 * @param token
	 * @return
	 * @throws ManagerNotFoundException
	 * @throws EmployeeNotFoundException
	 */
	public Employee deleteManagerById(int id, String token) throws ManagerNotFoundException, EmployeeNotFoundException {
		isHomeManager(id, token);
		return userDetailsClient.deleteEmployee(id, true, token);
	}

	/**
	 * 
	 * @param homeManager
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public Employee addManager(Employee homeManager, String token) throws Exception {
		validateHomeManager(homeManager);
		homeManager.setHomeManager(true);
		return userDetailsClient.addEmployee(homeManager, token);
	}

	/**
	 * 
	 * @param id
	 * @param homeManager
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public Employee updateManager(int id, Employee homeManager, String token) throws Exception {
		isHomeManager(id, token);
		validateHomeManager(homeManager);
		return userDetailsClient.updateEmployee(id, homeManager, token);

	}
}
