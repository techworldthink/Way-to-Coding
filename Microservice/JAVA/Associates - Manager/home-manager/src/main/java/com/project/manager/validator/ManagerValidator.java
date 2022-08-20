package com.project.manager.validator;

import org.springframework.stereotype.Component;
import com.project.manager.entity.HomeManager;
import com.project.manager.exception.InvalidNameException;

@Component("managerValidator")
public class ManagerValidator {
	public void validateHomeManager(HomeManager homeManager) throws Exception {
		if (homeManager.getFirstName().isBlank())
			throw new InvalidNameException("Invalid Name!");
	}
}
