package com.project.manager.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.manager.feign.exceptions.CustomErrorDecoder;
import com.project.manager.service.ManagerService;

import feign.FeignException;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(ManagerService.class);

	@ExceptionHandler(ManagerNotFoundException.class)
	public ResponseEntity<ExceptionDetails> handleManagerNotFoundException(ManagerNotFoundException ex) {
		ExceptionDetails exceptionDetail = new ExceptionDetails();
		exceptionDetail.setCode(HttpStatus.BAD_REQUEST.value());
		exceptionDetail.setMessage(ex.getMessage());
		exceptionDetail.setTimestamp(LocalDateTime.now());
		logger.error("Manager ID invalid");
		return new ResponseEntity<>(exceptionDetail, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(InvalidNameException.class)
	public ResponseEntity<ExceptionDetails> handleInvalidNameException(InvalidNameException ex) {
		ExceptionDetails exceptionDetail = new ExceptionDetails();
		exceptionDetail.setCode(HttpStatus.BAD_REQUEST.value());
		exceptionDetail.setMessage(ex.getMessage());
		exceptionDetail.setTimestamp(LocalDateTime.now());
		logger.error("Invalid manager name");
		return new ResponseEntity<>(exceptionDetail, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(AssignNotFoundException.class)
	public ResponseEntity<ExceptionDetails> handleAssignNotFoundException(AssignNotFoundException ex) {
		ExceptionDetails exceptionDetail = new ExceptionDetails();
		exceptionDetail.setCode(HttpStatus.BAD_REQUEST.value());
		exceptionDetail.setMessage(ex.getMessage());
		exceptionDetail.setTimestamp(LocalDateTime.now());
		logger.error("Assign not found");
		return new ResponseEntity<>(exceptionDetail, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ExceptionDetails> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
		ExceptionDetails exceptionDetail = new ExceptionDetails();
		exceptionDetail.setCode(HttpStatus.BAD_REQUEST.value());
		exceptionDetail.setMessage(ex.getMessage());
		exceptionDetail.setTimestamp(LocalDateTime.now());
		logger.error("Employee not found");
		return new ResponseEntity<>(exceptionDetail, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(InvalidReAssignException.class)
	public ResponseEntity<ExceptionDetails> handleInvalidReAssignException(InvalidReAssignException ex) {
		ExceptionDetails exceptionDetail = new ExceptionDetails();
		exceptionDetail.setCode(HttpStatus.CONFLICT.value());
		exceptionDetail.setMessage(ex.getMessage());
		exceptionDetail.setTimestamp(LocalDateTime.now());
		logger.error("Associate not found");
		return new ResponseEntity<>(exceptionDetail, HttpStatus.CONFLICT);

	}

	@ExceptionHandler(EmployeeEmptyException.class)
	public ResponseEntity<ExceptionDetails> handleProductEmptyException(EmployeeEmptyException ex) {
		ExceptionDetails exceptionDetail = new ExceptionDetails();
		exceptionDetail.setCode(HttpStatus.NOT_FOUND.value());
		exceptionDetail.setMessage(ex.getMessage());
		exceptionDetail.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ExceptionDetails>(exceptionDetail, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<ExceptionDetails> handleAuthorizationException(AuthorizationException ex) {
		ExceptionDetails exceptionDetail = new ExceptionDetails();
		exceptionDetail.setCode(HttpStatus.FORBIDDEN.value());
		exceptionDetail.setMessage(ex.getMessage());
		exceptionDetail.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(exceptionDetail, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<ExceptionDetails> handleAuthenticationException(AuthenticationException ex) {
		ExceptionDetails exceptionDetail = new ExceptionDetails();
		exceptionDetail.setCode(HttpStatus.UNAUTHORIZED.value());
		exceptionDetail.setMessage(ex.getMessage());
		exceptionDetail.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(exceptionDetail, HttpStatus.UNAUTHORIZED);
	}

//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<ExceptionDetails> handleGeneralException(Exception ex) {
//		ExceptionDetails exceptionDetail = new ExceptionDetails();
//		exceptionDetail.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//		exceptionDetail.setMessage(ex.getMessage());
//		exceptionDetail.setTimestamp(LocalDateTime.now());
//		return new ResponseEntity<>(exceptionDetail, HttpStatus.INTERNAL_SERVER_ERROR);
//
//	}
}