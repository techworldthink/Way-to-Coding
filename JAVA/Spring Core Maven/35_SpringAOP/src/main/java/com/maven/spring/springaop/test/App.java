package com.maven.spring.springaop.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.maven.spring.springaop.ProductService;

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/maven/spring/springaop/test/config.xml");

		ProductService obj = (ProductService) ctx.getBean("productService");
		System.out.println(obj.multiply(0, 0));

		((AbstractApplicationContext) ctx).close();
	}
}
