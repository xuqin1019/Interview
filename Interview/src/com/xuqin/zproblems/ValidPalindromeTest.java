/**
 * 
 */
package com.xuqin.zproblems;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author xuqin
 *
 * 
 */
@RunWith(JUnit4.class)
public class ValidPalindromeTest {
	private ValidPalindrome validPalindrome;
	
	@Before
	public void init() {
		validPalindrome = new ValidPalindrome();
	}
	
	@Test
	public void test() {
		assertTrue(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
		assertFalse(validPalindrome.isPalindrome("race a car"));
	}

}
