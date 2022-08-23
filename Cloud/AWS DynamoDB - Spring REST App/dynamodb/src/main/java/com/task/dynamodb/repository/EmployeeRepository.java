package com.task.dynamodb.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.task.dynamodb.model.Employee;

@Repository
public class EmployeeRepository {

	@Autowired
	private DynamoDBMapper mapper;

	public Employee addEmployee(Employee employee) {
		mapper.save(employee);
		return employee;
	}

	public Employee findEmployeeById(int id) {
		return mapper.load(Employee.class, id);
	}

	public String deleteEmployee(int id) {
		Employee employee = mapper.load(Employee.class, id);
		mapper.delete(employee);
		return "Employee deleted";
	}

	public String editEmployee(Employee employee) {
		mapper.save(employee, buildExpression(employee));
		return "Data updated";
	}

	private DynamoDBSaveExpression buildExpression(Employee employee) {
		DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
		Map<String, ExpectedAttributeValue> expectedMap = new HashMap<String, ExpectedAttributeValue>();
		expectedMap.put("id", new ExpectedAttributeValue(new AttributeValue().withN(String.valueOf(employee.getId()))));
		dynamoDBSaveExpression.setExpected(expectedMap);
		return dynamoDBSaveExpression;
	}
}
