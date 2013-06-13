package com.xuqin.zproblems;

import java.util.ArrayList;

public class PascalTriangle2 {
	public ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> result = new ArrayList<Integer>();
        Integer[] preResult = new Integer[rowIndex+1];
        for(int i=0;i<rowIndex+1;++i) {
        	result.clear();
        	for(int j=0;j<i+1;++j) {
        		if(j==0 || j==i) {
        			result.add(1);
        		} else {
        			result.add(j, preResult[j-1]+preResult[j]);
        		} 
        	}
        	preResult = result.toArray(new Integer[1]);
        }
        return result;  
    }
	
	public static void main(String[] args) {
		PascalTriangle2 pascalTriangle2 = new PascalTriangle2();
		System.out.println(pascalTriangle2.getRow(3));
	}
}
