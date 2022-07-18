package com.maven.spring.list;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/maven/spring/list/listconfig.xml");
		Hospital obj = (Hospital) ctx.getBean("hospital");
		System.out.println("Name : " + obj.getName());
		System.out.println("ID : " + obj.getDepartments());
		((AbstractApplicationContext) ctx).close();
	}

}
