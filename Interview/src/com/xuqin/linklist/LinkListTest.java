package com.xuqin.linklist;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

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
		assertArrayEquals(new Object[]{0,1,2,3,4,5,6,7,8,9}, linklist.getValues());
		assertFalse(linklist.delete(-1));
		assertTrue(linklist.delete(6));
		assertEquals(9, linklist.getSize());
		assertTrue(linklist.delete(9));
		assertArrayEquals(new Object[]{0,1,2,3,4,5,7,8}, linklist.getValues());
		assertNull(linklist.find(9));
		assertTrue(linklist.delete(0));
		assertEquals(7, linklist.getSize());
		assertNotNull(linklist.insert(11));
		assertArrayEquals(new Object[]{1,2,3,4,5,7,8,11}, linklist.getValues());
	}
	
}
