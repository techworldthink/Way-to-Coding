package com.example.ctsproject.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class ExceptionDetails {
private String message;
private HttpStatus code; 
private LocalDateTime timestamp;
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public HttpStatus getCode() {
	return code;
}
public void setCode(HttpStatus code) {
	this.code = code;
}
public LocalDateTime getTimestamp() {
	return timestamp;
}
public void setTimestamp(LocalDateTime timestamp) {
	this.timestamp = timestamp;
}

}