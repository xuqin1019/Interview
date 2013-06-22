/**
 * 
 */
package com.xuqin.zproblems;

/**
 * @author xuqin
 *
 * 
 */
public class MaximalRectangle {
	 public int maximalRectangle(char[][] matrix) {
		 if(matrix==null || matrix.length==0) {
			 return 0;
		 }
		 
		 int maxArea = 0;
		 Item [][] results = new Item[matrix.length][matrix[0].length];
		 for(int i=0;i<matrix.length;++i) {
			 for(int j=0;j<matrix[0].length;++j) {
				 if(matrix[i][j] =='0') {
					 results[i][j] = new Item(0,0);
				 } else {
					 int preFromLeft = 0, preFromUp=0;
					 if(i==0) {
						 preFromLeft=0;
					 } else {
						 preFromLeft = results[i-1][j].fromLeft;
					 } 
					 if(j==0) {
						 preFromUp=0;
					 } else {
						 preFromUp = results[i][j-1].fromUp;
					 }
					 
					 int fromLeft = 1+preFromLeft;
					 int fromUp = 1+preFromUp;
					 results[i][j] = new Item(fromLeft, fromUp);
					 maxArea = Math.max(Math.max(fromLeft, fromUp),maxArea);
				 }
			 }
		 }
		 return maxArea;
	}
	 
	 static class Item {
		 int fromLeft;
		 int fromUp;
		
		 public Item(int fromLeft, int fromUp) {
			this.fromLeft = fromLeft;
			this.fromUp = fromUp;
		 }
	 } 
}
