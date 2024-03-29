package com.project.manager.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionDetails {
	private String message;
	private int code;
	private String timestamp;

	public void setTimestamp(LocalDateTime now) {
		this.timestamp = now.toString();

	}
}