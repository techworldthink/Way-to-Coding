package com.project.activity.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Activity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int activityId;
	private String title;
	private String description;
	/*private boolean status;
	public void setDeleted(boolean b) {
		// TODO Auto-generated method stub
		
	}
	public void setDeleted(boolean b) {
		// TODO Auto-generated method stub
		
	}*/
}



