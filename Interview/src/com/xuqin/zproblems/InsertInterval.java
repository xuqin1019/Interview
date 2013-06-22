package com.xuqin.zproblems;

import java.util.ArrayList;

public class InsertInterval {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> results = new ArrayList<Interval>();
        
        if(intervals.isEmpty()) {
        	results.add(newInterval);
        	return results;
		}
        
        if(!overlap(intervals.get(0), newInterval) && newInterval.start < intervals.get(0).start) {
        	intervals.add(0, newInterval);
        	return intervals;
        }
        
        if(!overlap(intervals.get(intervals.size()-1), newInterval) && newInterval.end > intervals.get(intervals.size()-1).end) {
        	intervals.add(newInterval);
        	return intervals;
        }
        
        boolean shouldAdd = false;
        int times = 0;
        for(int i=0;i<intervals.size();++i) {
        	Interval interval = intervals.get(i);
        	if(overlap(interval, newInterval)) {
        		times++;
        		newInterval = mergeInterval(interval, newInterval);
        		if(shouldAdd==false) {
        			shouldAdd = true;
        		}
        	} else {
        		
        		if(times==0 && newInterval.end<interval.start) {
        			results.add(newInterval);
        			times++;
        		}
        		
        		if(shouldAdd) {
        			results.add(newInterval);
        			shouldAdd = false;
        		}
        		
        		results.add(interval);
        	}
        }
        
        if(shouldAdd==true) {
        	results.add(newInterval);
        }
        
        return results;
    }
	
	private Interval mergeInterval(Interval interval1, Interval interval2) {
		Interval rInterval = new Interval();
		rInterval.start = Math.min(interval1.start, interval2.start);
		rInterval.end = Math.max(interval1.end, interval2.end);
		return rInterval;
	}

	private boolean overlap(Interval interval1, Interval interval2) {
		Interval minInterval = (interval1.start<=interval2.start) ? interval1 : interval2;
		Interval maxInterval = (interval1.start>interval2.start) ? interval1 : interval2;
		return minInterval.end>=maxInterval.start;   //overlap				
	}

	static class Interval {
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
	
	
	//[[6,10],[13,16],[19,19],[23,25],[34,39],[41,43],[49,51]], [27,27]
	public static void main(String[] args) {
		InsertInterval insertInterval = new InsertInterval();
		ArrayList<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(6, 10));
		list.add(new Interval(13, 16));
		list.add(new Interval(19,19));
		list.add(new Interval(23,25));
		list.add(new Interval(34,39));
		list.add(new Interval(41, 43));
		list.add(new Interval(49, 51));
		ArrayList<Interval> result = insertInterval.insert(list, new Interval(27, 27));
		for(Interval interval : result) {
			System.out.println(interval.start + " " + interval.end);
		}
	}
}
