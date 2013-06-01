package com.xuqin.zproblems;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class LadderLengthTest {
	
	private LadderLength ladderLength;
	
	@Before 
	public void init() {
		ladderLength=new LadderLength();
	}
	
	@Test
	public void test() {
		String start = "hit";
		String end ="cog";
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		assertEquals(5, ladderLength.ladderLength(start, end, dict));
	}

}
