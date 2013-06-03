/**
 * 
 */
package jp.co.wap.exam.test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import jp.co.wap.exam.Problem1;
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
public class Problem1Test {
	@Test
	public void test() {
		Problem1 problem1 = new Problem1();
		List<Interval> intervals  = new ArrayList<Interval>();
	    intervals.add(new Interval("11:00", "13:30"));
	    intervals.add(new Interval("06:00", "09:00"));
	    intervals.add(new Interval("08:00", "12:00"));
	    assertEquals(2, problem1.getMaxIntervalOverlapCount(intervals));
	    
	    List<Interval> intervals2  = new ArrayList<Interval>();
	    intervals2.add(new Interval("9:00", "12:30"));
	    intervals2.add(new Interval("06:00", "09:30"));
	    intervals2.add(new Interval("12:00", "14:30"));
	    intervals2.add(new Interval("10:00", "10:30"));
	    intervals2.add(new Interval("11:00", "13:30"));
	    assertEquals(3, problem1.getMaxIntervalOverlapCount(intervals2));
	    
	}
	
	@Test
	public void TestBoundary() {
		Problem1 problem1 = new Problem1();
		List<Interval> intervals = null;
		assertEquals(0, problem1.getMaxIntervalOverlapCount(intervals));
		
		intervals = new ArrayList<Interval>();
		assertEquals(0, problem1.getMaxIntervalOverlapCount(intervals));
		
//		intervals.add(null);
//		problem1.getMaxIntervalOverlapCount(intervals);
//		intervals.clear();
//		
		intervals.add(new Interval("09:00", "12:00"));
		intervals.add(new Interval("06:00", "09:00"));
		assertEquals(2, problem1.getMaxIntervalOverlapCount(intervals));
		
		List<Interval> intervals2 = new ArrayList<Interval>();
		intervals2.add(new Interval("09:00", "09:00"));
		intervals2.add(new Interval("09:00", "09:00"));
		intervals2.add(new Interval("09:00", "09:00"));
		intervals2.add(new Interval("09:00", "09:00"));
		intervals2.add(new Interval("09:00", "11:00"));
		intervals2.add(new Interval("11:00", "11:00"));
		intervals2.add(new Interval("11:00", "11:00"));
		intervals2.add(new Interval("11:00", "11:00"));
		intervals2.add(new Interval("11:00", "11:00"));
		intervals2.add(new Interval("11:00", "11:00"));
		assertEquals(6, problem1.getMaxIntervalOverlapCount(intervals2));
		
		
	}
	
}
