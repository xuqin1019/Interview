package com.xuqin.zproblems;

public class RotateImage {
	 public void rotate(int[][] matrix) {
		 int n = matrix.length;
		 int cell = n/2;
		 
		 for(int i=0;i<cell;++i) {
			 
			 int [] temp = new int[n-2*i];     //the temp array size
			 int size = temp.length;
		//	 for(int j=0;j<4;++j) {   //four side (up , right , bottom , left)
				for(int k=0;k<size-1;++k) {
					temp[k] = matrix[i][size-k-1];        //temp <- up
					matrix[i][size-k-1] = matrix[k][i];   //up <- left
					matrix[k][i] = matrix[n-i-1][k];  //left <- bottom
					matrix[n-i-1][k] = matrix[size-k-1][n-i-1];  //bottom <- right
					matrix[size-k-1][n-i-1] = temp[k];         //right <- temp(up)
				}
		//	 }
		 }
	 }
	 
	 public static void main(String[] args) {
		RotateImage rotateImage = new RotateImage();
		int [][] matrix = new int[][] {{1,2},{3,4}};
		rotateImage.rotate(matrix);
	}
}
