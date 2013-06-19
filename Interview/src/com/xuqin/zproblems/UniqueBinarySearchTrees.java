package com.xuqin.zproblems;

public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		return numTrees(1,n);
    }

	private int numTrees(int m, int n) {
		int sum = 0;
		if(m==n) {
			return 1;
		}
		
		if(n-m==1) {
			return 2; 
		}
		
		if(m>n) {
			return 0;
		}
		
		for(int i=m;i<=n;++i) {
			int leftNum = numTrees(m,i-1);
			int rightNum = numTrees(i+1,n);
			if(leftNum!=0 && rightNum!=0) {
				sum+=leftNum*rightNum;
			} else {
				sum+=(leftNum+rightNum);
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		UniqueBinarySearchTrees uniqueBinarySearchTrees = new UniqueBinarySearchTrees();
		System.out.println(uniqueBinarySearchTrees.numTrees(3))	;
	}
}
