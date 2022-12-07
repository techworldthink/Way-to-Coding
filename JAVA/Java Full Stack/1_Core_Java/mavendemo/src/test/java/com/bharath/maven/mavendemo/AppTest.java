package com.bharath.maven.mavendemo;

import org.junit.Test;

import junit.framework.Assert;

public class AppTest {

	@Test
	public void givenANameWhenHelloThenReturnHelloName() {
		App app = new App();
		String result = app.hello("Bharath");
		Assert.assertNotNull(result);
		Assert.assertEquals("Hello Bharath", result);

	}
}
