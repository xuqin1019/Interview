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
public class StockTest {
	private Stock1 stock1;
	private Stock2 stock2;
	
	
	@Before
	public void init() {
		stock1 = new Stock1();
		stock2 = new Stock2();
	}
	
	@Test
	public void stock1Test() {
		assertEquals(8, stock1.maxProfit(new int[]{5,8,4,10,7,12,6}));
		assertEquals(8, stock1.maxProfitDC(new int[]{5,8,4,10,7,12,6}));
		
		assertEquals(27, stock2.maxProfit(new int[]{5,8,4,10,7,3,12,6,15}));
	}
}
