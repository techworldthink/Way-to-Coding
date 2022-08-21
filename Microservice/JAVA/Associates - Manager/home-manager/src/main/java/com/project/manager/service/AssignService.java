package com.project.manager.service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.manager.entity.AssignManagers;
import com.project.manager.exception.InvalidReAssignException;
import com.project.manager.repository.AssignedRepository;

@Service
public class AssignService {

	@Autowired
	private AssignedRepository assignedRepository;

	public String assignManager(AssignManagers assignManagers) throws Exception {
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
