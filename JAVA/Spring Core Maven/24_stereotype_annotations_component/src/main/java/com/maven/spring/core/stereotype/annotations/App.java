package com.maven.spring.core.stereotype.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/maven/spring/core/stereotype/annotations/config.xml");

		Instructor obj = (Instructor) ctx.getBean("instructor");
		System.out.println(obj);

		((AbstractApplicationContext) ctx).close();
	}
}
