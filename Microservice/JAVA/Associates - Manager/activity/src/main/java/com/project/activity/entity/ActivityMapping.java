package com.project.activity.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class ActivityMapping<Emploee> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mappingId;
	//private int employeeId;
	private String createDate;
	private String createdBy;
	@ManyToOne
	@JoinColumn(name = "Activityid")
	 private Activity activity;
	public void setEmployee(int employeeId) {	
		
	}
	
}
