/**
 * 
 */
package com.xuqin.zproblems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuqin
 *
 * 
 */
public class AllPermutation {
	public List<String> permutation(String s) {
		List<String> results = permutation(s, 0, s.length()-1);
		return results;
	}
	
	public List<String> permutation(String s , int start , int end) {
		List<String> result = new ArrayList<String>();
		if(end==start) {
			result.add(s.substring(start, end+1));
			return result;
		}
		
		for(int i=start;i<=end;++i) {
			String frontStr = s.substring(i,i+1);    //every character in the string
			if(s.substring(start, i).indexOf(frontStr)!=-1) {   //ignore the character have appeared before
				continue;
			}
			for(String subPerStr : permutation(s.substring(start,i)+s.substring(i+1,end+1))) {
				result.add(frontStr+subPerStr);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		AllPermutation allPermutation = new AllPermutation();
		String str = "hello";
		List<String> results = allPermutation.permutation(str);
		for(String result : results) {
			System.out.println(result);
		}
		System.out.println(results.size());
	}
}
