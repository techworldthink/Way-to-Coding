package com.project.activity.controller;

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

import com.project.activity.AuthClient;
import com.project.activity.entity.Activity;
import com.project.activity.entity.ActivityMapping;
import com.project.activity.entity.ActivityMappingModel;
import com.project.activity.entity.AuthResponse;
//import com.project.activity.entity.EmplyoeeMappingModel;
import com.project.activity.exception.ActivityEmptyException;
import com.project.activity.exception.ActivityMappingEmptyException;
import com.project.activity.exception.ActivityMappingNotFoundException;
import com.project.activity.exception.ActivityNotFoundException;
import com.project.activity.service.ActivityMappingService;
import com.project.activity.service.ActivityService;

@RestController
@RequestMapping("/activitymapping")
@CrossOrigin
public class ActivityMappingController {
	
	@Autowired
	private ActivityMappingService activityMappingService;
	

	@Autowired
	AuthClient authorisingClient;
	
	public boolean checkAuthentication(String requestTokenHeader) throws Exception {
		ResponseEntity<AuthResponse> valid = authorisingClient.getValidity(requestTokenHeader);
		return valid.getBody().isValid();
	}
	
	@GetMapping("/view/all")
	public List<ActivityMapping> getAllActivityMapping(@RequestHeader(value = "Authorization", required = true) String token) 
			throws Exception {
		if (checkAuthentication(token)) {
		return activityMappingService.getAllActivityMapping(token);
		} else {
			throw new Exception("Invalid token");
		}
	}

		
	
    @GetMapping(value="/view/{id}")
    public ActivityMapping getActivityMappingById(@PathVariable("id") int id, @RequestHeader("Authorization") final String token)
    		throws Exception{
    	if (checkAuthentication(token)) {
		return activityMappingService.getActivityMappingById(id,token);
    	}else {
			throw new Exception("Invalid token");
		}

	}
     
    @PostMapping(value="/add")
	public ActivityMapping addActivityMapping(@RequestBody ActivityMappingModel activityMappingModel, @RequestHeader("Authorization") final String token) 
			throws Exception{
    	if (checkAuthentication(token)) {
		return activityMappingService.addActivityMapping(activityMappingModel,token);

	} else {
		throw new Exception("Invalid token");
	}
}

   @DeleteMapping("/delete/{id}")
	public ActivityMapping deleteActivityMapping(@PathVariable("id") int id, @RequestHeader("Authorization") final String token)
			throws Exception {
	   if (checkAuthentication(token)) {
		return activityMappingService.deleteActivityMapping(id,token);
	}
	   else {
			throw new Exception("Invalid token");
		}
   }
}