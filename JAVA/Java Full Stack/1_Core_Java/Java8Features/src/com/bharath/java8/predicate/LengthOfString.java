package com.bharath.java8.predicate;

import java.util.function.Predicate;

public class LengthOfString {

	public static void main(String[] args) {
		
		Predicate<String> p = s->(s.length()>5);
		
		System.out.println(p.test("xyz"));
		System.out.println(p.test("bharath"));

	}

}
