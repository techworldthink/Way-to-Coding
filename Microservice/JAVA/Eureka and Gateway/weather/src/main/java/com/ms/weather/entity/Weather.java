package com.ms.weather.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Weather {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int weatherId;

	private String indiaState;
	private int temperature;
	private int humidity;
	private int wind;

}