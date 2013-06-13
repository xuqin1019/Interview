package com.xuqin.zproblems;

import java.util.ArrayList;

public class PascalTriangle {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        Integer[] preResult = new Integer[numRows];
        for(int i=0;i<numRows;++i) {
        	ArrayList<Integer> result = new ArrayList<Integer>();
        	for(int j=0;j<i+1;++j) {
        		if(j==0 || j==i) {
        			result.add(1);
        		} else {
        			result.add(j, preResult[j-1]+preResult[j]);
        		} 
        	}
        	results.add(result);
        	preResult = result.toArray(new Integer[1]);
        }
        return results;
    }
	
	public static void main(String[] args) {
		PascalTriangle pascalTriangle = new PascalTriangle();
		ArrayList<ArrayList<Integer>> results = pascalTriangle.generate(5);
		System.out.println(results);
	}
}
