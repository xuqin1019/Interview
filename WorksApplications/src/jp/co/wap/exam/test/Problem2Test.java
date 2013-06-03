/**
 * 
 */
package jp.co.wap.exam.test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import jp.co.wap.exam.Problem2;
import jp.co.wap.exam.lib.Interval;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author xuqin
 *
 * 
 */
@RunWith(JUnit4.class)
public class Problem2Test {
	@Test
	public void test() {
		Problem2 problem2 = new Problem2();
		List<Interval> intervals  = new ArrayList<Interval>();
	    intervals.add(new Interval("12:30", "14:00"));
	    intervals.add(new Interval("9:00", "11:30"));
	    intervals.add(new Interval("10:30", "14:00"));
	    
	 //   intervals.add(new Interval("08:00", "09:00"));
	    intervals.add(new Interval("08:31", "08:51"));
	    
	    intervals.add(new Interval("6:00", "08:30"));
	    intervals.add(new Interval("09:00", "11:00"));
	    assertEquals(410, problem2.getMaxWorkingTime(intervals));
	    
	    List<Interval> intervals2  = new ArrayList<Interval>();
	    intervals2.add(new Interval("12:30", "14:00"));
	    intervals2.add(new Interval("12:30", "14:00"));
	    intervals2.add(new Interval("14:01", "16:00"));
	 //   intervals2.add(new Interval("16:01", "24:01"));
	    assertEquals(209, problem2.getMaxWorkingTime(intervals2));
	}
	
	@Test
	public void testBoundary() {
		Problem2 problem2 = new Problem2();
		List<Interval> intervals  = null;
		assertEquals(0, problem2.getMaxWorkingTime(intervals));
		
		intervals = new ArrayList<Interval>();
		assertEquals(0, problem2.getMaxWorkingTime(intervals));
		
		
	}
}
