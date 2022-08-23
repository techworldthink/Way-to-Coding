package com.task.dynamodb.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "Employee")
public class Employee {
	@DynamoDBHashKey
	private int id;
	@DynamoDBAttribute
	private String name;
	@DynamoDBAttribute
	private String gender;
	@DynamoDBAttribute
	private int age;
	@DynamoDBAttribute
	private double salary;
}
