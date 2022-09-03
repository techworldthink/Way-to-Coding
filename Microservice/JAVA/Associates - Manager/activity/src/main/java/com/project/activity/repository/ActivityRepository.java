package com.project.activity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.activity.entity.Activity;
@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {

	//Activity deleteActivity(int id, boolean b);

	//Activity deleteActivity(int id);

	//Activity deleteActivity(int id, boolean b);

	//Activity getActivityById(int id);

	//Activity getActivityById(int id);

}
