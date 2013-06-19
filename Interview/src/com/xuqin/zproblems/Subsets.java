package com.xuqin.zproblems;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
	 
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		Arrays.sort(S);
		return subsets(S,0,S.length-1);
	}

	private ArrayList<ArrayList<Integer>> subsets(int[] s, int i, int j) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		
		if(i>j) {
			ArrayList<Integer> result = new ArrayList<Integer>();
			results.add(result);
			return results;
		}
		
		ArrayList<ArrayList<Integer>> subSubSets = subsets(s,i+1,j);
		for(ArrayList<Integer> list : subSubSets) {
			results.add((ArrayList<Integer>) list.clone());
			list.add(0,s[i]);
			results.add((ArrayList<Integer>) list.clone());
		}
		return results;
	}
	
	
	public static void main(String[] args) {
		Subsets subsets = new Subsets();
		subsets.subsets(new int[]{1,2,3});
	}
	
}
