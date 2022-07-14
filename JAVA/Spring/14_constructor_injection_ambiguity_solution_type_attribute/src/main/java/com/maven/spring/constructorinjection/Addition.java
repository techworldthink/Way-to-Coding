package com.maven.spring.constructorinjection;

public class Addition {

	Addition(double a, double b) {
		System.out.println("Inside double");
	}

	Addition(int a, int b) {
		System.out.println("Inside int");
	}

	Addition(String a, String b) {
		System.out.println("Inside string");
	}

}
