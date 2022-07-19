package com.spring.learn;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {
	StringHelper obj = new StringHelper();

	private String input;
	private String expectedOutput;

	public StringHelperParameterizedTest(String input, String expectedOutput) {
		this.input = input;
		this.expectedOutput = expectedOutput;
	}

	@Parameters
	public static Collection<String[]> testConditions() {
		String expected[][] = { { "AACD", "CD" }, { "ABCD", "CD" } };
		return Arrays.asList(expected);
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getExpectedOutput() {
		return expectedOutput;
	}

	public void setExpectedOutput(String expectedOutput) {
		this.expectedOutput = expectedOutput;
	}

	@Test
	public void testTruncateAInFirst2Positions_cond1() {
		assertEquals(expectedOutput, obj.truncateAInFirst2Positions(input));
	}

}
