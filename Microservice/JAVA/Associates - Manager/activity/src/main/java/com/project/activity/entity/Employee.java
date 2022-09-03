package com.project.activity.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	private int empId;
	private String firstName;
	private String lastName;
	private String email;
	private String joinDate;
	private String endDate;
	private String role;
	private String mentorName;
	private boolean isHomeManager = true;
	private boolean status = true;
	private boolean isDeleted = false;
}