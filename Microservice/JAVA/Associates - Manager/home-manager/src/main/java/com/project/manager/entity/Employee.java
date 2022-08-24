package com.project.manager.entity;

import java.time.Instant;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
	private int Eid;
	private String FName;
	private String LName;
	private String Email;
	private String JoinDate;
	private String EndDate;
	private String MentorName;
	private boolean Status;
	private boolean IsDeleted;
}
