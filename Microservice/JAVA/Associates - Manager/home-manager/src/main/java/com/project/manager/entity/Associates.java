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
public class Associates {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int associateId;
	@NotBlank(message = "First name must not be blank")
	private String firstName;
	private String lastName;
	private Instant regDate;
}
