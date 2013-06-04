/**
 * 
 */
package com.xuqin.zproblems;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LongestConsecutiveSequenceTest {
	
	private LongestConsecutiveSequence longestConsecutiveSequence;
	
	@Before
	public void init() {
		longestConsecutiveSequence = new LongestConsecutiveSequence();
	}
	
	@Test
	public void test(){
		assertEquals(4, longestConsecutiveSequence.longestConsecutive(new int []{100,200,1,2,3,4}));
		assertEquals(5, longestConsecutiveSequence.longestConsecutive(new int []{5,10,200,1,3,2,8,4,9,11}));
	} 
}
