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
public class CuttingRodTest {
	
	private CuttingRod cuttingRod;
	
	@Before
	public void init() {
		cuttingRod = new CuttingRod();
	}
	
	@Test
	public void test() {
		assertEquals(22, cuttingRod.maxPrice(new int[]{1, 5, 8, 9, 10, 17, 17, 20}));
		assertEquals(24, cuttingRod.maxPrice(new int[]{3, 5, 8, 9, 10, 17, 17, 20}));
		assertEquals(27, cuttingRod.maxPrice(new int[]{1, 5, 8, 9, 10, 17, 17, 20,24,26}));
		
	}

}
