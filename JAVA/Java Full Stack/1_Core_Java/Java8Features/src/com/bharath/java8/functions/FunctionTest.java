package com.bharath.java8.functions;

import java.util.function.Function;

public class FunctionTest {

	public static void main(String[] args) {
		
		Function<String,Integer> f = s->s.length();
		System.out.println(f.apply("Bharath"));
		System.out.println(f.apply("John"));
	
	}

}
