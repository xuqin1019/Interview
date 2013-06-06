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
public class MergeSortedArrayTest {
	private MergeSortedArray mergeSortedArray;
	
	@Before
	public void init() {
		mergeSortedArray = new MergeSortedArray();
	}
	
	@Test
	public void test() {
		int [] a  = new int [100];
		a[0]=4;
		a[1]=6;
		a[2]=10;
		a[3]=15;
		
		int [] b = new int[] {1,2,3,5,6,8,11,14,16,20};
		
		mergeSortedArray.merge(a, 4, b, 10);
		
		int [] result = new int[] {1,2,3,4,5,6,6,8,10,11,14,15,16,20};
		for(int i=0;i<result.length;++i) {
			assertEquals(result[i], a[i]);
		}
	}

}
