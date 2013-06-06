/**
 * 
 */
package com.xuqin.zproblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author xuqin
 * LeetCode (Merge Intervals)  , similar to the WorksApplications/Problem1
 * 
 */

class Interval {
    int start;
    int end;
    
    Interval() { 
    	start = 0; 
    	end = 0; 
    }
    
    Interval(int s, int e) { 
    	start = s; 
    	end = e; 
    }
}


public class MergeIntervals {
	 public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		 if(intervals==null || intervals.size()<2) {
			 return intervals;
		 }
		 
		 ArrayList<Interval> results = new ArrayList<Interval>();
		 List<TimePoint> points = new ArrayList<TimePoint>(); 
		 for(Interval interval : intervals) {
			 points.add(new TimePoint(interval.start, State.START));
			 points.add(new TimePoint(interval.end, State.END));
		 }
		 
		 Collections.sort(points);
		 
		 Stack<Integer> stack = new Stack<Integer>(); 
		 stack.push(points.get(0).value);
		 
		 for(int i=1;i<points.size();++i) {      //use stack 
			 TimePoint p = points.get(i);
			 if(p.state==State.START) {
				 stack.push(p.value);
			 } else {                          //is an end point
				 int start = stack.pop();
				 if(stack.isEmpty()) {         //check to see if stack is empty
					 results.add(new Interval(start, p.value));
				 }
			 }
		 }
		 
		 return results;
	 }
	 
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
		
		public static void main(String [] args) {
//			MergeIntervals mergeIntervals = new MergeIntervals();
//			List<Interval> results = mergeIntervals.merge(Arrays.asList(new Interval []{new Interval(1,3),new Interval(2,7),new Interval(8,10),new Interval(10,11)}));
//			for(Interval interval : results) {
//				System.out.println(interval.start + " " + interval.end);
//			}
		}
}

