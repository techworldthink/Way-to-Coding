package com.bharath.java8.lambdas.basics;


public class Test {

	public static void main(String[] args) {
		
		A a = ()->System.out.println("Inside MyMethod");
		a.myMethod();

	}

}
