package com.project.manager.service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.manager.client.AssociatesClient;
import com.project.manager.entity.AssignManagers;
import com.project.manager.entity.HomeManager;
import com.project.manager.exception.AssignNotFoundException;
import com.project.manager.exception.AssociateNotFoundException;
import com.project.manager.exception.InvalidReAssignException;
import com.project.manager.exception.ManagerNotFoundException;
import com.project.manager.repository.AssignedRepository;
import com.project.manager.repository.ManagerRepository;
import com.project.manager.validator.AssociateValidator;
import com.project.manager.validator.ManagerValidator;

@Service
public class AssignService {

	@Autowired
	private AssignedRepository assignedRepository;

	@Autowired
	private ManagerRepository managerRepository;

	@Autowired
	private ManagerValidator managerValidator;

	@Autowired
	private AssociateValidator associateValidator;

	public AssignManagers assignManager(AssignManagers assignManagers) throws Exception {
		//if(associateValidator.isAssociateValid(assignManagers.getAssociateId()))
		//	throw new AssociateNotFoundException("Associate not found");
		if (!managerRepository.existsById(assignManagers.getManagerId()))
			throw new InvalidReAssignException("Manager not found");
		int associateId = assignManagers.getAssociateId();
		if (assignedRepository.existsByAssociateId(associateId))
			throw new InvalidReAssignException("Associate already assigned!");
		assignManagers.setAssignDate(Instant.now());
		assignedRepository.save(assignManagers);
		return assignManagers;
	}

	public List<AssignManagers> getAllAssigns() {
		return assignedRepository.findAll();
	}

	public AssignManagers getAssignsById(int id) throws Exception {
		return assignedRepository.findById(id)
				.orElseThrow(() -> new AssignNotFoundException("No such Assignment found"));
	}

	public AssignManagers deleteAssignsById(int id) throws AssignNotFoundException {
		AssignManagers assigned = assignedRepository.findById(id)
				.orElseThrow(() -> new AssignNotFoundException("No such Assignment found"));
		assignedRepository.deleteById(id);
		return assigned;
	}

	public AssignManagers updateAssignedManager(int id, AssignManagers assignManagers) throws Exception {
		AssignManagers assigned = assignedRepository.findById(id)
				.orElseThrow(() -> new AssignNotFoundException("No such Assignment found"));
		if (!managerRepository.existsById(assignManagers.getManagerId()))
			throw new InvalidReAssignException("Manager not found");
		assigned.setManagerId(assignManagers.getManagerId());
		assigned.setAssignDate(Instant.now());
		assignedRepository.save(assigned);
		return assigned;
	}

}
