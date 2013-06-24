package com.xuqin.zproblems;

import java.util.Arrays;

public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		int [] lastNumOfRows = getArray(matrix); 
		int rowIndex = search(lastNumOfRows, target,0,lastNumOfRows.length-1);
		
		if(rowIndex > matrix.length-1) {
			return false;
		}
		
		if(matrix[rowIndex][matrix[0].length-1]==target) {
			return true;
		}
		return Arrays.binarySearch(matrix[rowIndex],target)>=0;
    }

	public int search(int[] matrix, int target,int start,int end) {
		
		if(start>end) {
			return start;
		}
		
		if(start==end) {
			if(matrix[start]==target) {
				return start;
			} else if(matrix[start]<target) {
				return start+1;
			} else {
				return start;
			}
		}
		
		int middle = start+(end-start)/2;
		if(target<matrix[middle]) {
			return search(matrix, target, start, middle-1);
		} else if(target>matrix[middle]){
			return search(matrix, target, middle+1, end);
		} else {
			return middle;
		}
	}

	private int[] getArray(int[][] matrix) {
		int [] array = new int[matrix.length];
		for(int i=0;i<matrix.length;++i) {
			array[i]=matrix[i][matrix[0].length-1];
		}
		return array;
	}
	
	public static void main(String[] args) {
		SearchA2DMatrix searchA2DMatrix = new SearchA2DMatrix();
	//	int [] matrix = new int[]{1,3};
	//	System.out.println(searchA2DMatrix.search(matrix,0,0, matrix.length-1));
		int [][] matrix = new int [][] {{1,3}};
		System.out.println(searchA2DMatrix.searchMatrix(matrix, 2));
		System.out.println(Arrays.binarySearch(new int[]{1,3},2));
	}
}
