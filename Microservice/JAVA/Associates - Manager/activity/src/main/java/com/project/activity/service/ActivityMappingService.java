package com.project.activity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.project.activity.AuthClient;
import com.project.activity.client.UserDetailsClient;
import com.project.activity.entity.Activity;
//import com.project.activity.entity.Activity;
import com.project.activity.entity.ActivityMapping;
import com.project.activity.entity.ActivityMappingModel;
//import com.project.activity.entity.EmplyoeeMappingModel;
//import com.project.activity.exception.ActivityMappingEmptyException;
import com.project.activity.exception.ActivityMappingEmptyException;
import com.project.activity.exception.ActivityMappingNotFoundException;
import com.project.activity.repository.ActivityMappingRepository;
import com.project.activity.repository.ActivityRepository;

@Service
public class ActivityMappingService {

	@Autowired
	private ActivityMappingRepository activityMappingRepository;

	@Autowired
	private ActivityRepository activityRepository;
	
	@Autowired
	AuthClient authClient;

	@Autowired
	private UserDetailsClient userDetailsClient;

	public List<ActivityMapping> getAllActivityMapping(String Token) throws ActivityMappingEmptyException {

		List<ActivityMapping> list = activityMappingRepository.findAll();
		if (!list.isEmpty())
			return list;
		else
			throw new ActivityMappingEmptyException("There is No ActivityMapping Data");
	}

	public ActivityMapping getActivityMappingById(int id,String Token) throws ActivityMappingNotFoundException {

		ActivityMapping activityMapping = activityMappingRepository.findById(id).orElse(null);
		if (activityMapping != null)
			return activityMapping;
		else
			throw new ActivityMappingNotFoundException();
	}

	public ActivityMapping addActivityMapping(ActivityMappingModel activityMappingModel,String Token) throws Exception {
		Activity activity = activityRepository.findById(activityMappingModel.getActivityid()).orElse(null);
		if (activity != null) {
			ActivityMapping activityMapping = new ActivityMapping();
			activityMapping.setActivity(activity);
			activityMapping.setCreateDate(activityMappingModel.getCreateDate());
			activityMapping.setCreatedBy(activityMappingModel.getCreatedBy());
			activityMapping.setEmployee(activityMappingModel.getEmployeeId());
			return activityMappingRepository.save(activityMapping);
		} else
			throw new Exception("Activity id does not exist");
	}

	public ActivityMapping deleteActivityMapping(int id,String Token) throws Exception {

		Optional<ActivityMapping> optAct = activityMappingRepository.findById(id);
		if (!optAct.isPresent()) {
			throw new Exception("ActivityMapping Main with the id " + id + " does not exist");
		} else {
			ActivityMapping act = optAct.get();

			activityMappingRepository.delete(act);
			return act;
		}
	}

}
