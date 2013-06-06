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
public class PalindromePartitioningTest {
	private PalindromePartitioning2 PalindromePartitioning2;
	
	@Before 
	public void init() {
		PalindromePartitioning2 = new PalindromePartitioning2();
	}
	
	@Test
	public void test() {
		assertEquals(1, PalindromePartitioning2.minCut("aab"));
		assertEquals(2, PalindromePartitioning2.minCut("aabaca"));
	}

}
