package com.spring.learn;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ArraysCompareTest {

	@Test(timeout = 100)
	public void testArraySort_Performance() {
		int[] array = { 1, 3, 2 };
		for (int i = 1; i <= 1000000; i++) {
			array[0] = i;
			Arrays.sort(array);
		}
	}

}
