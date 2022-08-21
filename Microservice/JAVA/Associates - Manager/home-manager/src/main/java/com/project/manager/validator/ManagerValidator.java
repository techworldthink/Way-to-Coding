package com.project.manager.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import com.project.manager.entity.HomeManager;
import com.project.manager.exception.InvalidNameException;

@Component("managerValidator")
public class ManagerValidator {
	public void validateHomeManagerByName(String homeManager) throws Exception {
		String regex = "[A-Za-z]{0,30}$";
		Pattern pattern = Pattern.compile(regex);
		if (homeManager.isBlank())
			throw new InvalidNameException("Invalid Name!");
		if (!pattern.matcher(homeManager).matches())
			throw new InvalidNameException("Invalid Name!");
	}
}
