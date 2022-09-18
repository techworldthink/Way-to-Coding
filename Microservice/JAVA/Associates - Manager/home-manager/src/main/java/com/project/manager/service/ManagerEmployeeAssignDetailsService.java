package com.project.manager.service;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.manager.client.UserDetailsClient;
import com.project.manager.entity.AssignManagers;
import com.project.manager.entity.Employee;
import com.project.manager.entity.ManagerEmployeeAssignResponse;
import com.project.manager.repository.AssignedRepository;
import com.project.manager.exception.AssignDetailsGetException;

@Service
public class ManagerEmployeeAssignDetailsService {

	@Autowired
	private UserDetailsClient userDetailsClient;

	@Autowired
	private AssignedRepository assignedRepository;

	public List<ManagerEmployeeAssignResponse> getAssignedManagersDetails(String requestTokenHeader) throws Exception {
		List<AssignManagers> assignDetails = assignedRepository.findAll();
		List<Employee> homeManagers = userDetailsClient.getHomeManagers(requestTokenHeader);
		List<Employee> employee = userDetailsClient.getEmployee(requestTokenHeader);
		List<ManagerEmployeeAssignResponse> data = new ArrayList<>();

		if (assignDetails == null)
			throw new AssignDetailsGetException("Assign Details Empty!");
		if (homeManagers == null)
			throw new AssignDetailsGetException("Managers Details Empty!");
		if (employee == null)
			throw new AssignDetailsGetException("Employee Details Empty!");

		for (AssignManagers row : assignDetails) {
			ManagerEmployeeAssignResponse mapObj = new ManagerEmployeeAssignResponse();
			List<Employee> result = homeManagers.stream().filter(item -> item.getEmpId() == (row.getManagerId()))
					.collect(Collectors.toList());
			if (result == null)
				throw new AssignDetailsGetException("Manager Not Found Error!");
			mapObj.setManagerName(result.get(0).getFirstName());

			result = employee.stream().filter(item -> item.getEmpId() == (row.getEmployeeId()))
					.collect(Collectors.toList());
			if (result == null)
				throw new AssignDetailsGetException("Employee Not Found Error!");
			mapObj.setEmployeeName(result.get(0).getFirstName());

			mapObj.setAssignDate(row.getAssignDate().substring(0, 10));
			mapObj.setAssignId(row.getAssignId());

			data.add(mapObj);
		}

		return data;
	}

}
