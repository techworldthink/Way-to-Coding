package com.learn.ms.ws.service.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(StateNotFoundException.class)
	public ResponseEntity<ExceptionDetails> handleMovieNotFoundException(StateNotFoundException ex) {
		ExceptionDetails exceptionDetail = new ExceptionDetails();
		exceptionDetail.setCode(HttpStatus.NOT_FOUND);
		exceptionDetail.setMessage(ex.getMessage());
		exceptionDetail.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(exceptionDetail, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(WeatherEmptyException.class)
	public ResponseEntity<ExceptionDetails> handleMovieEmptyException(WeatherEmptyException ex) {
		ExceptionDetails exceptionDetail = new ExceptionDetails();
		exceptionDetail.setCode(HttpStatus.NOT_FOUND);
		exceptionDetail.setMessage(ex.getMessage());
		exceptionDetail.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(exceptionDetail, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionDetails> handleGeneralException(Exception ex) {
		ExceptionDetails exceptionDetail = new ExceptionDetails();
		exceptionDetail.setCode(HttpStatus.NOT_FOUND);
		exceptionDetail.setMessage(ex.getMessage());
		exceptionDetail.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(exceptionDetail, HttpStatus.NOT_FOUND);

	}

}
