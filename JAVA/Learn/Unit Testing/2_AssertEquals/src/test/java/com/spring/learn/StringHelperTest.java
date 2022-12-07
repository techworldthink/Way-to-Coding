package com.spring.learn;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringHelperTest {

	@Test
	public void test() {
		// expected , actual
		// assertEquals("ABC", "ABC");

		StringHelper obj = new StringHelper();
		assertEquals("CD", obj.truncateAInFirst2Positions("AACD"));
		assertEquals("CD", obj.truncateAInFirst2Positions("ACD"));
		assertEquals("CDEF", obj.truncateAInFirst2Positions("CDEF"));
		assertEquals("CDAA", obj.truncateAInFirst2Positions("CDAA"));
		assertEquals("A", obj.truncateAInFirst2Positions("AAA"));
	}

}
