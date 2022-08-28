package com.project.manager.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.manager.client.UserDetailsClient;
import com.project.manager.entity.Employee;

@Component("associateValidator")
public class AssociateValidator {
	
	@Autowired
	private UserDetailsClient userDetailsClient;

	public boolean isAssociateValid(int associateId) throws Exception {
		try {
			Employee associate = userDetailsClient.getEmployeeById(associateId);
			return true;
		} catch (Exception exception) {
			throw exception;
		}
	}
}
