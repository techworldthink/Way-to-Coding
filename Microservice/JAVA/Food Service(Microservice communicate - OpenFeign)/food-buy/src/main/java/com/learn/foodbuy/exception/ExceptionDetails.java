package com.learn.foodbuy.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExceptionDetails {
	private String message;
	private HttpStatus code;
	private LocalDateTime timestamp;
}