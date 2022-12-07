package com.maven.spring.jdbc.learnJdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.maven.spring.jdbc.learnJdbc.employee.dao.EmployeeDao;
import com.maven.spring.jdbc.learnJdbc.employee.dto.Employee;

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/maven/spring/jdbc/learnJdbc/config.xml");
		EmployeeDao obj = (EmployeeDao) ctx.getBean("employeeDao");

		Employee employee = new Employee();
		employee.setId(1);
		employee.setFirstname("A");
		employee.setLastname("B");

		int result = obj.create(employee);
		System.out.println("Number of records are inserted : " + result);

		((AbstractApplicationContext) ctx).close();
	}
}
