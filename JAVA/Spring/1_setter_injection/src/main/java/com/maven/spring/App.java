package com.maven.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		Employee obj = (Employee) ctx.getBean("emp");
		System.out.println("ID : " + obj.getId());
		System.out.println("Name : " + obj.getName());
	}

}
