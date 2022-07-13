package com.maven.spring.dependencycheck;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/maven/spring/dependencycheck/config.xml");
		Prescription obj = (Prescription) ctx.getBean("prescription");
		//System.out.println(obj.getId());
		//System.out.println(obj.getPatientName());
		//System.out.println(obj.getMedicines());
		System.out.println(obj);
		((AbstractApplicationContext) ctx).close();
	}

}
