package com.project.manager.entity;

import java.time.Instant;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
