package com.spring.learn;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ArraysCompareTest {

	@Test(expected=NullPointerException.class)
	public void testArraySort_RandomArray() {
		int[] numbers = null;
		Arrays.sort(numbers);
	}
	
	@Test(expected=NullPointerException.class)
	public void testArraySort_RandomArray2() {
		int[] numbers = {};
		Arrays.sort(numbers);
	}

}
