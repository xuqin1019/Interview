package com.xuqin.zproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Subsets2 {
	 public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		 Arrays.sort(num);
		 return new ArrayList<ArrayList<Integer>>(subsets(num, 0, num.length-1));
	 }
	 
	 private Set<ArrayList<Integer>> subsets(int[] s, int i, int j) {
			Set<ArrayList<Integer>> results = new HashSet<ArrayList<Integer>>();
			
			if(i>j) {
				ArrayList<Integer> result = new ArrayList<Integer>();
				results.add(result);
				return results;
			}
			
			Set<ArrayList<Integer>> subSubSets = subsets(s,i+1,j);
			for(ArrayList<Integer> list : subSubSets) {
				results.add((ArrayList<Integer>) list.clone());
				list.add(0,s[i]);
				results.add((ArrayList<Integer>) list.clone());
			}
			return results;
	}
	 
	 public static void main(String[] args) {
		 Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		 ArrayList<Integer> list = new ArrayList<Integer>();
		 list.add(1);
		 list.add(2);
		 ArrayList<Integer> list2 = new ArrayList<Integer>();
		 list2.add(1);
		 list2.add(2);
		 set.add(list);
		 set.add(list2);
		 System.out.println(set.size());
	 }
}
