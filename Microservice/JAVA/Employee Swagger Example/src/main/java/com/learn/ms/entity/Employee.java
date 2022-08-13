package com.learn.ms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Employee class wich is acting as the DTO")
public class Employee {
	@Id
	private int id;
	@ApiModelProperty(notes = "Name should contain only Alphabtes")
	private String name;
	private String gender;
	@ApiModelProperty(notes = "Age should be betweeen 18 and 60")
	private int age;
	private double salary;
}
