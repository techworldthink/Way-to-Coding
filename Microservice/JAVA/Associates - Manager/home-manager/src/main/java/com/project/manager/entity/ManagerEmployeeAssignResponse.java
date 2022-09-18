package com.project.manager.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ManagerEmployeeAssignResponse {
	private int assignId;
	private String employeeName;
	private String managerName;
	private String assignDate;
}
