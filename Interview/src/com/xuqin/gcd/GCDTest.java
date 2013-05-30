package com.xuqin.gcd;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GCDTest {
	@Test
	public void test() {
		assertEquals(-1,GCD.gcd(3, 4));
		assertEquals(-1,GCD.gcd(-3, 4));
		assertEquals(-1,GCD.gcd(3, -4));
		assertEquals(-1,GCD.gcd(-3, -4));
		assertEquals(4,GCD.gcd(12, 8));
		assertEquals(5,GCD.gcd(50, 15));
		assertEquals(3,GCD.gcd(1989, 1590));
	}
}
