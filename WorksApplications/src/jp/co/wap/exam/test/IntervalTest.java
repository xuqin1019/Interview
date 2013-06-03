/**
 * 
 */
package jp.co.wap.exam.test;

import jp.co.wap.exam.lib.Interval;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;
/**
 * @author xuqin
 *
 * 
 */

@RunWith(JUnit4.class)
public class IntervalTest {
	@Test 
	public void test() {
		Interval interval = new Interval("11:00", "16:01");
		assertEquals("11:00",interval.getBegin());
		assertEquals("16:01", interval.getEnd());
		assertEquals(11, interval.getBeginHour());
		assertEquals(0, interval.getBeginMinute());
		assertEquals(16, interval.getEndHour());
		assertEquals(1, interval.getEndMinute());
		assertEquals(660, interval.getBeginMinuteUnit());
		assertEquals(961, interval.getEndMiniteUnit());
		assertEquals("[11:00-16:01]", interval.toString());
		assertEquals(301, interval.getIntervalMinute());
	}
}
