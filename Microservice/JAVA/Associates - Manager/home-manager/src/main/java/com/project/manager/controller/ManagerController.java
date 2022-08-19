package com.project.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.manager.entity.HomeManager;
import com.project.manager.service.ManagerService;

@RestController
@RequestMapping("/managers")
public class ManagerController {

	@Autowired
	private ManagerService managerService;

	@GetMapping("/view/all")
	public List<HomeManager> getAllManagers() {
		return managerService.getAllManagers();
	}

	@GetMapping("/view/{id}")
	public HomeManager getManagerById(@PathVariable("id") int id) throws Exception {
		return managerService.getManagerById(id);
	}
}
