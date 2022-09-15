package com.project.activity.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor


public class ActivityMappingModel {
	
	private int mappingId;
	private int employeeId;
	private String createDate;
	private String createdBy;
	private int activityid;
	
	
	
}
