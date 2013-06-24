package com.xuqin.zproblems;

public class SortColors {
	public void sortColors(int[] A) {
		int [] numbers = new int[3];
		for(int i=0;i<A.length;++i) {
			numbers[A[i]]++;
		}
		int pos = 0;
		for(int i=0;i<numbers.length;++i) {
			int num = numbers[i];
			for(int j=0;j<num;++j) {
				A[pos++] = i;
			}
		} 
    }
}
