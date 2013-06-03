package jp.co.wap.exam;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.wap.exam.lib.Interval;

/**
 * @author xuqin
 *
 * 
 */
public class Problem2 {
	/**
	 * @param intervals
	 * @return the maximum work time(minutes) to assign to one worker
	 */
	public int getMaxWorkingTime(List<Interval> intervals) {
		if(intervals==null || intervals.isEmpty()) {
			return 0;
		}
		
		if(intervals.size()>10000) {
			throw new IllegalArgumentException("The number of  intervals must not exceed 10000.");
		}
		
		//validation of the input parameter
		if(invalidInput(intervals)) {
			throw new IllegalArgumentException("Input intervals list contains null element.");
		}
		
		
		//sort the intervals according to its' endTime , sort by startTime if two endTimes are identical
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval interval1, Interval interval2) {
				if(interval1.getEndMiniteUnit()!=interval2.getEndMiniteUnit()) {
					return interval1.getEndMiniteUnit()-interval2.getEndMiniteUnit();
				} else {
					return interval1.getBeginMinuteUnit()-interval2.getBeginMinuteUnit();
				}
			}
		});
		
		
		int maxWorkingTime=0;
		
		//use a map to keep the max working time associated with each particular interval 
		Map<Interval,Integer> preResult = new HashMap<Interval, Integer>();
		preResult.put(null,0);
		for(int i=0;i<intervals.size();++i) {
			Interval currInterval = intervals.get(i);
			Interval preIntervalWithPick = null;
			Interval preIntervalWithoutPick = null;
			
			//find out the previous non-overlapping interval
			for(int j=i-1;j>=0;--j) {
				Interval tempInterval = intervals.get(j);
				if(preIntervalWithoutPick==null && tempInterval.getEndMiniteUnit()<currInterval.getEndMiniteUnit()) {
					preIntervalWithoutPick = tempInterval;
				}
				if(preIntervalWithPick==null && tempInterval.getEndMiniteUnit()<currInterval.getBeginMinuteUnit()) {
					preIntervalWithPick = tempInterval;
				}
			}
			
			int valueWithPick = preResult.get(preIntervalWithPick)+currInterval.getIntervalMinute();
			int valueWithOutPick = preResult.get(preIntervalWithoutPick);
			int value = Math.max(valueWithPick, valueWithOutPick);
			preResult.put(currInterval, value);
			if(value>maxWorkingTime) {
				maxWorkingTime=value;
			}
		}
		
		return maxWorkingTime;
		
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

}
