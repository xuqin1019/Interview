/**
 * 
 */
package com.xuqin.zproblems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xuqin
 * LeeCode
 * 
 */
/**
 * @author xuqin
 * LeeCode (just use a set to record the elements and iterate the them to check the maximum consecutive sequence)
 * 
 */
public class LongestConsecutiveSequence {
	
	public int longestConsecutive(int[] num) {
        
        Set<Integer> hs = new HashSet<Integer>();
        for(int v : num) {
        	hs.add(v);
        }
        int ans = 0;
        
        for(int v : num) {
        	if(hs.contains(v)) {
        		ans = Math.max(ans , getCount(hs,v,false) + getCount(hs,v+1,true));
        	}
        }
        
        return ans;
    }

	
	private int getCount(Set<Integer> hs, int v, boolean asc) {
		int count = 0;
		while(hs.contains(v)) {
			hs.remove(v);
			++count;
			if(asc) {
				++v;
			} else {
				--v;
			}
		}
		return count;
	}
}
