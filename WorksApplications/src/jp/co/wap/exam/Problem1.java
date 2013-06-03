package jp.co.wap.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jp.co.wap.exam.lib.Interval;

/**
 * @author xuqin
 *
 * 
 */
public class Problem1 {
	/**
	 * @param intervals
	 * @return the maximum number of overlapped "intervals" at the same time
	 */
	public int getMaxIntervalOverlapCount(List<Interval> intervals) {
		if(intervals==null || intervals.isEmpty()) {
			return 0;
		}
		
		//validation of the input parameter
		if(invalidInput(intervals)) {
			throw new IllegalArgumentException("Input intervals list contains null element.");
		}
		
		//build a sorted list contains the time points sorted by its' minuteUnit 
		List<TimePoint> sortedTimePoints = buildSortedTimePoints(intervals);
		
		int maxCount = 0;
		int count=0;
		for(TimePoint timePoint : sortedTimePoints) {
			if(timePoint.state==State.START) {
				++count;
			} else {
				--count;
			}
			if(count>maxCount) {
				maxCount=count;
			}
		}
		return maxCount;
	}
	
	/**
	 * @param intervals
	 * @return true if intervals contains null , otherwise return false
	 */
	private boolean invalidInput(List<Interval> intervals) {
		for(Interval interval : intervals) {
			if(interval==null) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param intervals
	 * @return the list of sorted TimePoint 
	 */
	private List<TimePoint> buildSortedTimePoints(List<Interval> intervals) {
		List<TimePoint> timePoints = new ArrayList<TimePoint>();
		for(Interval interval : intervals) {
			timePoints.add(new TimePoint(interval.getBeginMinuteUnit(),State.START));
			timePoints.add(new TimePoint(interval.getEndMiniteUnit(), State.END));
		}
		Collections.sort(timePoints);
		return timePoints;
	}

	/**
	 * @author xuqin
	 * inner class 
	 * 
	 */
	class TimePoint implements Comparable<TimePoint>{
		int value;
		State state;
		public TimePoint(int value, State state) {
			this.value = value;
			this.state = state;
		}
		
		public int getValue() {
			return value;
		}
		
		public State getState() {
			return state;
		}

		@Override
		public int compareTo(TimePoint other) {  
			if(this.value!=other.value) {
				return this.value-other.value; 
			} else {
				return this.state.compareTo(other.state);
			}
		}
	}
	
	enum State {
		START,END;
	}
}
