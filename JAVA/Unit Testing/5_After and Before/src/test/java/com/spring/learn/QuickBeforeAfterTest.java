package com.spring.learn;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuickBeforeAfterTest {
	StringHelper obj;

	@Before
	public void setup() {
		obj = new StringHelper();
		System.out.println("Before test");
	}

	@Test
	public void test1() {
		System.out.println("Test1 executed");
	}

	@Test
	public void test2() {
		System.out.println("Test2 executed");
	}

	@After
	public void teardown() {
		System.out.println("After test");
	}
}
