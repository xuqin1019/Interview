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
public class Permutations {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();

		if(num.length==0) {
			return results;
		}
		
		if(num.length==1) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(num[0]);
			results.add(list);
			return results;
		}
		
		for(int i=0;i<num.length;++i) {
			int value = num[i];
			
			int [] subNum = getSubNum(num,i);
			
			ArrayList<ArrayList<Integer>> subList = permute(subNum);
			for(ArrayList<Integer> list : subList) {
				list.add(0, value);
			}
			results.addAll(subList);
		}
		
		return results;
	}

	private int[] getSubNum(int[] num, int exclude) {
		
		int [] subNum = new int[num.length-1];
		System.arraycopy(num, 0, subNum, 0, exclude);
		System.arraycopy(num,exclude+1, subNum, exclude, num.length-exclude-1);
		
		return subNum;
	}

	public static void main(String[] args) {
		Permutations permutations = new Permutations();
		System.out.println(permutations.permute(new int[]{1,2,3}));
	}
}
