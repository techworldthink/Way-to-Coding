package com.project.manager.service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.manager.client.UserDetailsClient;
import com.project.manager.entity.AssignManagers;
import com.project.manager.entity.Employee;
import com.project.manager.exception.AssignNotFoundException;
import com.project.manager.exception.EmployeeNotFoundException;
import com.project.manager.exception.InvalidReAssignException;
import com.project.manager.exception.ManagerNotFoundException;
import com.project.manager.repository.AssignedRepository;

@Service
public class AssignService {

	@Autowired
	private UserDetailsClient userDetailsClient;

	@Autowired
	private AssignedRepository assignedRepository;

	/**
	 * 
	 * @param assignManagers
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public AssignManagers assignManager(AssignManagers assignManagers, String token) throws Exception {

		Employee employeeDetails = userDetailsClient.getEmployeeById(assignManagers.getEmployeeId(), token);
		Employee managerDetails = userDetailsClient.getEmployeeById(assignManagers.getManagerId(), token);

		if (!managerDetails.isHomeManager())
			throw new ManagerNotFoundException("Manager not found");

		if (employeeDetails.isHomeManager())
			throw new EmployeeNotFoundException("Employee not found");

		if (assignedRepository.existsByEmployeeId(assignManagers.getEmployeeId()))
			throw new InvalidReAssignException("Associate already assigned!");

		assignManagers.setAssignDate(Instant.now().toString());
		assignedRepository.save(assignManagers);
		return assignManagers;

	}

	/**
	 * 
	 * @return
	 */
	public List<AssignManagers> getAllAssigns() {
		return assignedRepository.findAll();
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public AssignManagers getAssignsById(int id) throws Exception {
		return assignedRepository.findById(id)
				.orElseThrow(() -> new AssignNotFoundException("No such Assignment found"));
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws AssignNotFoundException
	 */
	public AssignManagers deleteAssignsById(int id) throws AssignNotFoundException {
		AssignManagers assigned = assignedRepository.findById(id)
				.orElseThrow(() -> new AssignNotFoundException("No such Assignment found"));
		assignedRepository.deleteById(id);
		return assigned;
	}

	/**
	 * 
	 * @param id
	 * @param assignManagers
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public AssignManagers updateAssignedManager(int id, AssignManagers assignManagers, String token) throws Exception {

		AssignManagers assigned = assignedRepository.findById(id)
				.orElseThrow(() -> new AssignNotFoundException("No such Assignment found"));

		Employee managerDetails = userDetailsClient.getEmployeeById(assignManagers.getManagerId(), token);

		if (!managerDetails.isHomeManager())
			throw new ManagerNotFoundException("Manager not found");

		assigned.setManagerId(assignManagers.getManagerId());
		assigned.setAssignDate(Instant.now().toString());
		assignedRepository.save(assigned);
		return assigned;
	}

}
