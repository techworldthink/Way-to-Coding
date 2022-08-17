
package com.collateral.loans.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AuthResponseTest {

	AuthResponse auth = new AuthResponse();
	AuthResponse auth1 = new AuthResponse("ad", "ad", true);

	@Test
	void testUid() {
		auth.setUid("Uid");
		assertEquals(auth.getUid(), "Uid");
	}

	@Test
	void testName() {
		auth.setName("Name");
		assertEquals(auth.getName(), "Name");
	}

	@Test
	void testIsValid() {
		auth.setValid(true);
		assertEquals(auth.isValid(), true);
	}

}
