package com.maven.spring.constructorinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/maven/spring/constructorinjection/config.xml");

		Addition obj = (Addition) ctx.getBean("addition");
		System.out.println(obj);

		((AbstractApplicationContext) ctx).close();
	}
}
