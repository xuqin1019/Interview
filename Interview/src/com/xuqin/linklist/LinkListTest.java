package com.xuqin.linklist;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class LinkListTest {
	
	private LinkList<Integer> linklist = null;
	
	
	@Before
	public void init() {
		linklist = new LinkList<Integer>();
	}
	
	@Test
	public void test() {
		for(int i=0;i<10;++i) {
			linklist.insert(i);
		}
		assertEquals(10, linklist.getSize());
		assertArrayEquals(new Object[]{9,8,7,6,5,4,3,2,1,0}, linklist.getValues());
		assertEquals(0,linklist.delete(-1));
		assertEquals(1,linklist.delete(6));
		assertEquals(9, linklist.getSize());
		assertEquals(1,linklist.delete(9));
		assertArrayEquals(new Object[]{8,7,5,4,3,2,1,0}, linklist.getValues());
		assertNull(linklist.find(9));
		assertEquals(1,linklist.delete(0));
		assertEquals(7, linklist.getSize());
		assertNotNull(linklist.insert(11));
		assertArrayEquals(new Object[]{11,8,7,5,4,3,2,1}, linklist.getValues());

		assertNotNull(linklist.insert(5));
		assertNotNull(linklist.insert(11));
		assertNotNull(linklist.insert(11));
		assertEquals(3, linklist.delete(11));
		assertEquals(2, linklist.delete(5));
		assertArrayEquals(new Object[]{8,7,4,3,2,1}, linklist.getValues());


	}
	
}
