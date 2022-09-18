package com.project.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.manager.client.AuthenticationClient;
import com.project.manager.entity.AuthResponse;
import com.project.manager.entity.Employee;
import com.project.manager.entity.ManagerEmployeeAssignResponse;
import com.project.manager.exception.AuthorizationException;
import java.util.List;
import com.project.manager.service.ManagerEmployeeAssignDetailsService;

@RestController
@CrossOrigin
@RequestMapping("/mapping")
public class ManagerEmployeeAssignDetailsController {

	@Autowired
	AuthenticationClient authorisingClient;

	@Autowired
	private ManagerEmployeeAssignDetailsService assignService;

	/**
	 * 
	 * @param requestTokenHeader
	 * @return
	 * @throws Exception
	 */
	public boolean checkAuthentication(String requestTokenHeader) throws Exception {
		try {
			ResponseEntity<AuthResponse> valid = authorisingClient.getValidity(requestTokenHeader);
			return valid.getBody().isValid();
		} catch (Exception e) {

		}
		return false;
	}

	@GetMapping("/view")
	public List<ManagerEmployeeAssignResponse> getAssignedManagersDetails(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws Exception {

		if (checkAuthentication(requestTokenHeader)) {
			return assignService.getAssignedManagersDetails(requestTokenHeader);
		} else {
			throw new AuthorizationException("Invalid token");
		}
	}

}
