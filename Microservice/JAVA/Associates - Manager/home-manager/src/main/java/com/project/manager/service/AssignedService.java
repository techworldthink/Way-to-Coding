package com.project.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.manager.repository.AssignedRepository;

@Service
public class AssignedService {
	@Autowired
	private AssignedRepository assignedRepository;
}
