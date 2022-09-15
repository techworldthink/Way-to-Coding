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
import com.project.activity.entity.AuthResponse;
import com.project.activity.service.ActivityService;

@RestController
@RequestMapping("/activity")
@CrossOrigin
public class ActivityController {

	@Autowired
	private ActivityService activityService;

	@Autowired
	AuthClient authorisingClient;

	public boolean checkAuthentication(String requestTokenHeader) throws Exception {
		ResponseEntity<AuthResponse> valid = authorisingClient.getValidity(requestTokenHeader);
		return valid.getBody().isValid();
	}

	@GetMapping("/view/all")
	public List<Activity> getAllActivities(@RequestHeader(value = "Authorization", required = true) String token)
			throws Exception {

		if (checkAuthentication(token)) {
			return activityService.getAllActivites(token);
		} else {
			throw new Exception("Invalid token");
		}
	}

	@GetMapping(value = "/view/{id}")
	public Activity getActivityById(@PathVariable("id") int id, @RequestHeader("Authorization") final String token)
			throws Exception {

		if (checkAuthentication(token)) {
			return activityService.getActivityById(id, token);
		} else {
			throw new Exception("Invalid token");
		}
	}

	@PostMapping(value = "/add")
	public Activity addActivity(@RequestBody Activity activity, @RequestHeader("Authorization") final String token)
			throws Exception {

		if (checkAuthentication(token)) {
			return activityService.addActivity(activity, token);
		} else {
			throw new Exception("Invalid token");
		}
	}

	@DeleteMapping("/delete/{id}")
	public Activity deleteActivityById(@PathVariable("id") int id, @RequestHeader("Authorization") final String token)
			throws Exception {

		if (checkAuthentication(token)) {
			return activityService.getActivityById(id, token);
		} else {
			throw new Exception("Invalid token");
		}
	}

	@PutMapping(value = "/update/{id}")
	public Activity updateActivity(@PathVariable("id") int id, @RequestBody Activity activity,
			@RequestHeader("Authorization") final String token) throws Exception {

		if (checkAuthentication(token)) {
			return activityService.updateActivity(id, activity, token);
		} else {
			throw new Exception("Invalid token");
		}
	}

}
