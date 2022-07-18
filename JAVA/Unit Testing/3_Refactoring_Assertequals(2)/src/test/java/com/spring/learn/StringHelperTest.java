package com.spring.learn;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringHelperTest {
	StringHelper obj = new StringHelper();

	@Test
	public void testTruncateAInFirst2Positions_cond1() {
		assertEquals("CD", obj.truncateAInFirst2Positions("AACD"));
	}

	@Test
	public void testTruncateAInFirst2Positions_cond2() {
		assertEquals("CD", obj.truncateAInFirst2Positions("ACD"));
	}

}
