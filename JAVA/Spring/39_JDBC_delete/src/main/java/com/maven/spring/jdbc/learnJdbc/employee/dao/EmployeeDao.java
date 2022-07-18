package com.maven.spring.jdbc.learnJdbc.employee.dao;

import com.maven.spring.jdbc.learnJdbc.employee.dto.Employee;

public interface EmployeeDao {
	int create(Employee employee);
	int update(Employee employee);
	int delete(Employee employee);
}
