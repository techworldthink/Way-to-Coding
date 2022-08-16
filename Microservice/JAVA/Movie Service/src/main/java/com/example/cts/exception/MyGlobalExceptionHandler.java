package com.example.cts.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyGlobalExceptionHandler {
	
	@ExceptionHandler(MovieNotFoundException.class)
	public ResponseEntity<ExceptionDetails> handleMovieNotFoundException(MovieNotFoundException ex){
		ExceptionDetails exceptionDetail = new ExceptionDetails();
		exceptionDetail.setCode(HttpStatus.NOT_FOUND);
		exceptionDetail.setMessage(ex.getMessage());
		exceptionDetail.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(exceptionDetail, HttpStatus.NOT_FOUND);
		
	}

	@ExceptionHandler(MovieEmptyException.class)
	public ResponseEntity<ExceptionDetails> handleMovieEmptyException(MovieEmptyException ex){
		ExceptionDetails exceptionDetail = new ExceptionDetails();
		exceptionDetail.setCode(HttpStatus.NOT_FOUND);
		exceptionDetail.setMessage(ex.getMessage());
		exceptionDetail.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(exceptionDetail, HttpStatus.NOT_FOUND);
		
	}
}
