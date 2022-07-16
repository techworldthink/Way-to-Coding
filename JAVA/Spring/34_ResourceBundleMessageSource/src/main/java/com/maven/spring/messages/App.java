package com.maven.spring.messages;

import java.util.Locale;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("locale.xml");

		String name;

		name = context.getMessage("customer.name", new Object[] { 28, 0 }, Locale.US);
		System.out.println("Customer name (US) : " + name);

		name = context.getMessage("customer.name", new Object[] { 29, 1 }, Locale.ENGLISH);
		System.out.println("Customer name (English) : " + name);

		name = context.getMessage("customer.name", new Object[] { 30, 2 },
				Locale.SIMPLIFIED_CHINESE);

		System.out.println("Customer name (Chinese) : " + name);

	}
}
