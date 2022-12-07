package com.maven.spring.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/maven/spring/autowiring/config.xml");

		Employee obj = (Employee) ctx.getBean("employee");
		System.out.println(obj);

		((AbstractApplicationContext) ctx).close();
	}
}
