/**
 * 
 */
package com.xuqin.zproblems;

import java.util.ArrayList;

/**
 * @author xuqin
 *
 * 
 */
public class GrayCode {
	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> results = new ArrayList<Integer>();
		int count = 0x01 << n;
		for(int i=0;i<count;++i) {
			results.add(i^(i>>1));
		}
		return results;
    }	
}
