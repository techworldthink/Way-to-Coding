package com.project.activity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.activity.entity.ActivityMapping;
@Repository
public interface ActivityMappingRepository extends JpaRepository<ActivityMapping, Integer> {

	//Activity deleteActivity(int id, boolean b);

	//Activity getActivityById(int id);

	//Activity getActivityById(int id);

}