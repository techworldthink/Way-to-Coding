package com.maven.spring.propertyplaceholder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/maven/spring/propertyplaceholder/config.xml");
		DAO obj = (DAO) ctx.getBean("DAO");
		System.out.println(obj);
		((AbstractApplicationContext) ctx).close();
	}

}
