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
		
	}
	
}
