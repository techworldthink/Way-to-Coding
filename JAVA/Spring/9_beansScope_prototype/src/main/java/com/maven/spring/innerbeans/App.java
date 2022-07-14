package com.maven.spring.innerbeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/maven/spring/innerbeans/config.xml");

		Employee obj = (Employee) ctx.getBean("employee");
		System.out.println(obj.hashCode());

		Employee obj2 = (Employee) ctx.getBean("employee");
		System.out.println(obj2.hashCode());

		((AbstractApplicationContext) ctx).close();
	}
}
