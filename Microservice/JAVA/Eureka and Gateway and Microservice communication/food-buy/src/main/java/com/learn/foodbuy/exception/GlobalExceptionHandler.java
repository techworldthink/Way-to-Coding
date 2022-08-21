package com.learn.foodbuy.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import feign.FeignException;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(FeignException.class)
	public ResponseEntity<ExceptionDetails> handleFeignException(FeignException ex) {
		ExceptionDetails exceptionDetail = new ExceptionDetails();
		exceptionDetail.setCode(HttpStatus.NOT_FOUND);
		exceptionDetail.setMessage(ex.getMessage());
		exceptionDetail.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(exceptionDetail, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(FoodItemNotFoundException.class)
	public ResponseEntity<ExceptionDetails> handleFoodItemNotFoundException(FoodItemNotFoundException ex) {
		ExceptionDetails exceptionDetail = new ExceptionDetails();
		exceptionDetail.setCode(HttpStatus.NOT_FOUND);
		exceptionDetail.setMessage(ex.getMessage());
		exceptionDetail.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(exceptionDetail, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(InvalidOrderException.class)
	public ResponseEntity<ExceptionDetails> handleInvalidOrderException(InvalidOrderException ex) {
		ExceptionDetails exceptionDetail = new ExceptionDetails();
		exceptionDetail.setCode(HttpStatus.NOT_FOUND);
		exceptionDetail.setMessage(ex.getMessage());
		exceptionDetail.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(exceptionDetail, HttpStatus.NOT_FOUND);

	}
}
