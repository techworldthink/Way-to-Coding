package com.project.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.manager.entity.HomeManager;
import com.project.manager.exception.ManagerNotFoundException;
import com.project.manager.repository.AssignedRepository;
import com.project.manager.repository.ManagerRepository;

@Service
public class ManagerService {

	@Autowired
	private ManagerRepository managerRepository;

	public List<HomeManager> getAllManagers() {
		return managerRepository.findAll();
	}

	public HomeManager getManagerById(int id) throws Exception {
		return managerRepository.findById(id)
				.orElseThrow(() -> new ManagerNotFoundException("Manager with ID: " + id + " not found"));
	}
}
