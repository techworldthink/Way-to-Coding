package com.project.manager.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.springframework.stereotype.Component;
import com.project.manager.exception.InvalidNameException;

@Component("managerValidator")
public class ManagerValidator {
	
	public void validateFirstName(String firstName) throws Exception {
		String regex = "[A-Za-z]{0,30}$";
		Pattern pattern = Pattern.compile(regex);
		if (firstName.isBlank())
			throw new InvalidNameException("Invalid Name!");
		if (!pattern.matcher(firstName).matches())
			throw new InvalidNameException("Invalid Name!");
	}
	
	public void validateNotNull(String data) throws Exception {
		if(data == null)
			throw new Exception("Null values Found Exception");
	}
	
	public void validateIsBoolean(String data) throws Exception {
		boolean result = Boolean.parseBoolean(data);
		if(!result)
			throw new Exception("Boolean values expect");
	}
	
	public void validateEmail(String email) throws Exception {
		String regex = "^(.+)@(.+)$";  
		Pattern pattern = Pattern.compile(regex); 
		Matcher matcher = pattern.matcher(email); 
		if(!matcher.matches())
			throw new Exception("Enter valid email");
	}
}