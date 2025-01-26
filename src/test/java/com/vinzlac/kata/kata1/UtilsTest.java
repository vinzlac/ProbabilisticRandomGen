package com.vinzlac.kata.kata1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class UtilsTest {

	@Test
	void testRoundDecimal() {
		assertEquals(1.23f, Utils.roundDecimal(1.2345f, 2));
		assertEquals(1.235f, Utils.roundDecimal(1.2345f, 3));
		assertEquals(1.0f, Utils.roundDecimal(1.0f, 2));
		assertEquals(0.0f, Utils.roundDecimal(0.0f, 2));
		assertEquals(-1.23f, Utils.roundDecimal(-1.2345f, 2));
	}
}