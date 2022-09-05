package com.project.authorization.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionDetails {
	private String message;
	private int code;
	private String timestamp;

	public void setTimestamp(LocalDateTime now) {
		this.timestamp = now.toString();
	}

}