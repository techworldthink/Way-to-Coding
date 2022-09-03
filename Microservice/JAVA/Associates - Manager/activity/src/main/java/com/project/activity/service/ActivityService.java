package com.project.activity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.activity.AuthClient;
import com.project.activity.entity.Activity;
import com.project.activity.entity.AuthResponse;
import com.project.activity.exception.ActivityEmptyException;
import com.project.activity.exception.ActivityNotFoundException;
import com.project.activity.repository.ActivityRepository;

@Service
public class ActivityService {
	@Autowired
	private ActivityRepository activityRepository;
	@Autowired
	AuthClient authClient;

	public List<Activity> getAllActivites(String token) throws Exception {
		List<Activity> list = activityRepository.findAll();
		if (!list.isEmpty()) {
			return list;
		} else {
			throw new ActivityNotFoundException("No student records to display");
		}
	}

	public Activity getActivityById(int id, String token) throws Exception {

		Activity acti = activityRepository.findById(id).orElse(null);
		if (acti != null)
			return acti;
		else
			throw new ActivityNotFoundException("Activity not found");

	}

	public Activity addActivity(Activity activity, String token) {
		return activityRepository.save(activity);
	}

	public Boolean deleteActivityById(int id) throws Exception {
		if (activityRepository.existsById(id)) {
			activityRepository.deleteById(id);
			return true;
		} else {
			throw new ActivityNotFoundException("Activity not found");
		}

	}

	public Activity updateActivity(int id, Activity activity, String token) {

		return activityRepository.save(activity);
	}

}
