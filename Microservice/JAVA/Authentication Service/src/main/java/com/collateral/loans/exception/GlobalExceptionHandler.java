package com.collateral.loans.exception;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import io.jsonwebtoken.MalformedJwtException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseTypeDTO> resourceNotFoundException(Exception ex, WebRequest request) {
    	ResponseTypeDTO errorResponse =new ResponseTypeDTO();
    	errorResponse.setErrMsg(ex.getMessage());
    	errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
    	errorResponse.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}