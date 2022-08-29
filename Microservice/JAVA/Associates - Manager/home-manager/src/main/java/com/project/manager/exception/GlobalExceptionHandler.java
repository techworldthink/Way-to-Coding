package com.project.manager.exception;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.project.manager.service.ManagerService;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(ManagerService.class);

	@ExceptionHandler(ManagerNotFoundException.class)
	public ResponseEntity<ExceptionDetails> handleManagerNotFoundException(ManagerNotFoundException ex) {
		ExceptionDetails exceptionDetail = new ExceptionDetails();
		exceptionDetail.setCode(HttpStatus.NOT_FOUND);
		exceptionDetail.setMessage(ex.getMessage());
		exceptionDetail.setTimestamp(LocalDateTime.now());
		logger.error("Manager ID invalid");
		return new ResponseEntity<>(exceptionDetail, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(InvalidNameException.class)
	public ResponseEntity<ExceptionDetails> handleInvalidNameException(InvalidNameException ex) {
		ExceptionDetails exceptionDetail = new ExceptionDetails();
		exceptionDetail.setCode(HttpStatus.NOT_FOUND);
		exceptionDetail.setMessage(ex.getMessage());
		exceptionDetail.setTimestamp(LocalDateTime.now());
		logger.error("Invalid manager name");
		return new ResponseEntity<>(exceptionDetail, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(AssignNotFoundException.class)
	public ResponseEntity<ExceptionDetails> handleAssignNotFoundException(AssignNotFoundException ex) {
		ExceptionDetails exceptionDetail = new ExceptionDetails();
		exceptionDetail.setCode(HttpStatus.NOT_FOUND);
		exceptionDetail.setMessage(ex.getMessage());
		exceptionDetail.setTimestamp(LocalDateTime.now());
		logger.error("Assign not found");
		return new ResponseEntity<>(exceptionDetail, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ExceptionDetails> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
		ExceptionDetails exceptionDetail = new ExceptionDetails();
		exceptionDetail.setCode(HttpStatus.NOT_FOUND);
		exceptionDetail.setMessage(ex.getMessage());
		exceptionDetail.setTimestamp(LocalDateTime.now());
		logger.error("Employee not found");
		return new ResponseEntity<>(exceptionDetail, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(InvalidReAssignException.class)
	public ResponseEntity<ExceptionDetails> handleInvalidReAssignException(InvalidReAssignException ex) {
		ExceptionDetails exceptionDetail = new ExceptionDetails();
		exceptionDetail.setCode(HttpStatus.NOT_FOUND);
		exceptionDetail.setMessage(ex.getMessage());
		exceptionDetail.setTimestamp(LocalDateTime.now());
		logger.error("Associate not found");
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

	@ExceptionHandler(EmployeeEmptyException.class)
	public ResponseEntity<ExceptionDetails> handleProductEmptyException(EmployeeEmptyException ex) {
		ExceptionDetails exceptionDetail = new ExceptionDetails();
		exceptionDetail.setCode(HttpStatus.NOT_FOUND);
		exceptionDetail.setMessage(ex.getMessage());
		exceptionDetail.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ExceptionDetails>(exceptionDetail, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<ExceptionDetails> handleAuthorizationException(AuthorizationException ex) {
		ExceptionDetails exceptionDetail = new ExceptionDetails();
		exceptionDetail.setCode(HttpStatus.NOT_FOUND);
		exceptionDetail.setMessage(ex.getMessage());
		exceptionDetail.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(exceptionDetail, HttpStatus.FORBIDDEN);
	}
}