package com.xuqin.stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StackTest {
	private Stack<Integer> stack;
	
	@Before
	public void init() {
		stack = new Stack<Integer>(10);
	} 
	
	@Test
	public void testStack() {
		stack.push(10);
		stack.push(5);
		assertEquals(2,stack.size());
		assertEquals(5, (int)stack.top());
		stack.pop();
		assertEquals(1,stack.size());
		for(int i=0;i<9;++i) {
			stack.push(i);
		}
		assertTrue(stack.isFull());
		assertNull(stack.push(100));
		for(int i=stack.size();i>0;--i) {
			stack.pop();
		}
		assertTrue(stack.isEmpty());
		assertEquals(null, stack.pop());
	}
	
	@Test
	public void t() {
		stack.push(10);
		assertEquals(1, stack.size());
	}
	
}
