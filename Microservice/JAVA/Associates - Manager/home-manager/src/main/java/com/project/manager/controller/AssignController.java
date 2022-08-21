package com.project.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.manager.entity.AssignManagers;
import com.project.manager.entity.HomeManager;
import com.project.manager.service.AssignService;
import com.project.manager.service.ManagerService;

@RestController
@RequestMapping("/assign")
public class AssignController {

	@Autowired
	private AssignService assignService;
	
	@GetMapping("/view/all")
	public List<AssignManagers> getAllAssigns() {
		return assignService.getAllAssigns();
	}

	@GetMapping("/view/{id}")
	public AssignManagers getAssignById(@PathVariable("id") int id) throws Exception {
		return assignService.getAssignsById(id);
	}
	
	@PostMapping("/add")
	public AssignManagers assignManager(@RequestBody AssignManagers assignManagers) throws Exception {
		return assignService.assignManager(assignManagers);
	}
	
	@DeleteMapping("/delete/{id}")
	public AssignManagers deleteAssignById(@PathVariable("id") int id) throws Exception {
		return assignService.deleteAssignsById(id);
	}
}
