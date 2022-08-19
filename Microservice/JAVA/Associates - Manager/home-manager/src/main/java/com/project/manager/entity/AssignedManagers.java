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
public class AssignedManagers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int assignId;
	private String managerId;
	private String associateId;
	private Instant assignDate;
}
