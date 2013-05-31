package com.xuqin.tree;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class SearchTreeTest {
	
	private SearchTree<Integer> searchTree=null;
	
	@Before
	public void init() {
		Integer [] elems = new Integer[] {8,11,4,7,6,2,12,10};
		searchTree = new SearchTree<Integer>(elems);
	}
	
	@Test
	public void test() {
		Integer [] results =convertResults(searchTree.preOrder());
		assertEquals(new Integer[] {8,4,2,7,6,11,10,12}, results);
		results = convertResults(searchTree.midOrder());
		assertEquals(new Integer[] {2,4,6,7,8,10,11,12},results);
		results = convertResults(searchTree.postOrder());
		assertEquals(new Integer[] {2,6,7,4,10,12,11,8},results);
		assertNotNull(searchTree.findNode(6));
		assertNull(searchTree.findNode(1));
		
		searchTree.insertNode(3);
		results = convertResults(searchTree.midOrder());
		assertEquals(new Integer[] {2,3,4,6,7,8,10,11,12},results);
		
	}
	
	private Integer[] convertResults(Object [] results) {
		Integer [] intResults = new Integer[results.length];
		for(int i=0;i<results.length;++i) {
			intResults[i]=(Integer)results[i];
		}
		return intResults;
	}
}
