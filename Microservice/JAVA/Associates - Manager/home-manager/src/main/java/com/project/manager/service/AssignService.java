package com.project.manager.service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.manager.entity.AssignManagers;
import com.project.manager.exception.InvalidReAssignException;
import com.project.manager.repository.AssignedRepository;
import com.project.manager.repository.ManagerRepository;
import com.project.manager.validator.ManagerValidator;

@Service
public class AssignService {

	@Autowired
	private AssignedRepository assignedRepository;

	@Autowired
	private ManagerRepository managerRepository;

	@Autowired
	private ManagerValidator managerValidator;

	public String assignManager(AssignManagers assignManagers) throws Exception {
		if (!managerRepository.existsById(assignManagers.getManagerId()))
			throw new InvalidReAssignException("Manager not found");
		int associateId = assignManagers.getAssociateId();
		if (assignedRepository.existsByAssociateId(associateId))
			throw new InvalidReAssignException("Associate already assigned!");
		assignManagers.setAssignDate(Instant.now());
		assignedRepository.save(assignManagers);
		return "Success";
	}

	public List<AssignManagers> getAllAssigns() {
		return assignedRepository.findAll();
	}
}
