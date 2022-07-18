package com.maven.spring.core.injecting.interfaces;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/maven/spring/core/injecting/interfaces/config.xml");

		OrderBo obj = (OrderBo) ctx.getBean("bo");
		obj.placeOrder();
		//System.out.println(obj);

		((AbstractApplicationContext) ctx).close();
	}
}
