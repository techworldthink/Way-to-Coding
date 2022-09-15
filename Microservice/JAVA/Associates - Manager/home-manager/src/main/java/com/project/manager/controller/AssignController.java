package com.project.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.manager.client.AuthenticationClient;
import com.project.manager.entity.AssignManagers;
import com.project.manager.entity.AuthResponse;
import com.project.manager.exception.AuthorizationException;
import com.project.manager.service.AssignService;

@RestController
@CrossOrigin
@RequestMapping("/assign")
public class AssignController {

	@Autowired
	private AssignService assignService;

	@Autowired
	AuthenticationClient authorisingClient;

	public boolean checkAuthentication(String requestTokenHeader) throws Exception {
		try {
			ResponseEntity<AuthResponse> valid = authorisingClient.getValidity(requestTokenHeader);
			return valid.getBody().isValid();
		} catch (Exception e) {

		}
		return false;
	}

	@GetMapping("/view/all")
	public List<AssignManagers> getAllAssigns(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader)
			throws AuthorizationException, Exception {

		if (checkAuthentication(requestTokenHeader)) {
			return assignService.getAllAssigns();
		} else {
			throw new AuthorizationException("Invalid token");
		}
	}

	@GetMapping("/view/{id}")
	public AssignManagers getAssignById(@PathVariable("id") int id,
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws Exception {

		if (checkAuthentication(requestTokenHeader)) {
			return assignService.getAssignsById(id);
		} else {
			throw new AuthorizationException("Invalid token");
		}
	}

	@PostMapping("/add")
	public AssignManagers assignManager(@RequestBody AssignManagers assignManagers,
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws Exception {

		if (checkAuthentication(requestTokenHeader)) {
			return assignService.assignManager(assignManagers, requestTokenHeader);
		} else {
			throw new AuthorizationException("Invalid token");
		}
	}

	@PutMapping("/update/{id}")
	public AssignManagers updateAssignedManager(@PathVariable("id") int id, @RequestBody AssignManagers assignManagers,
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws Exception {

		if (checkAuthentication(requestTokenHeader)) {
			return assignService.updateAssignedManager(id, assignManagers, requestTokenHeader);
		} else {
			throw new AuthorizationException("Invalid token");
		}
	}

	@DeleteMapping("/delete/{id}")
	public AssignManagers deleteAssignsById(@PathVariable("id") int id,
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws Exception {

		if (checkAuthentication(requestTokenHeader)) {
			return assignService.deleteAssignsById(id);
		} else {
			throw new AuthorizationException("Invalid token");
		}
	}

}
