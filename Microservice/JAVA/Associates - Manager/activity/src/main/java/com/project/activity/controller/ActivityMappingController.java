package com.project.activity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.activity.entity.Activity;
import com.project.activity.entity.ActivityMapping;
import com.project.activity.entity.ActivityMappingModel;
//import com.project.activity.entity.EmplyoeeMappingModel;
import com.project.activity.exception.ActivityEmptyException;
import com.project.activity.exception.ActivityMappingEmptyException;
import com.project.activity.exception.ActivityMappingNotFoundException;
import com.project.activity.exception.ActivityNotFoundException;
import com.project.activity.service.ActivityMappingService;
import com.project.activity.service.ActivityService;

@RestController
@RequestMapping("/activitymapping")

public class ActivityMappingController {
	
	@Autowired
	private ActivityMappingService activityMappingService;
	
	@GetMapping("/view/all")
	public List<ActivityMapping> getAllActivityMapping() throws ActivityMappingEmptyException {
		return activityMappingService.getAllActivityMapping();
		
	}
    @GetMapping(value="/view/{id}")
    public ActivityMapping getActivityMappingById(@PathVariable("id") int id) throws ActivityMappingNotFoundException{
		return activityMappingService.getActivityMappingById(id);
	}
    
    @PostMapping(value="/add")
	public ActivityMapping addActivityMapping(@RequestBody ActivityMappingModel ActivityMappingModel) throws Exception{
		return activityMappingService.addActivityMapping(ActivityMappingModel);
	}
   /* @PostMapping(value="/add")
	public ActivityMapping addActivityMapping(@RequestBody EmplyoeeMappingModel EmplyoeeMappingModel) throws Exception{
		return activityMappingService.addActivityMapping(EmplyoeeMappingModel);
	}
    */
    @PutMapping("/delete/{id}")
	public ActivityMapping deleteActivityMapping(@PathVariable int id, @RequestBody boolean isDeleted) throws Exception {
		return activityMappingService.deleteActivityMapping(id, isDeleted);
	}

}
