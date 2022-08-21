package com.project.manager.entity;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AssignManagers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int assignId;
	private int managerId;
	private int associateId;
	private Instant assignDate;
}
