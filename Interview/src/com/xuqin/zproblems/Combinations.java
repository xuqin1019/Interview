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
public class Combinations {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		return combine(k,1,n);    //choose k number of elements from n
	}

	private ArrayList<ArrayList<Integer>> combine(int k, int start, int end) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		if(k>end-start+1) {
			return result;
		} else if (k==1) {
			for(int i = start;i<=end;++i) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				result.add(list);
			}
			return result;
		} 
		
		for(int i=start;i<=end;++i) {
			ArrayList<ArrayList<Integer>> subResult = combine(k-1, i+1, end);   //choose the start number
			for(ArrayList<Integer> list : subResult) {
				list.add(0, i);
			}
			result.addAll(subResult);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Combinations combinations = new Combinations();
		System.out.println(combinations.combine(4, 2));
	}
}
