package com.xuqin.zproblems;

public class RotateImage {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		int cells = n / 2;

		for (int i = 0; i < cells; ++i) {

			int[] temp = new int[n - 2 * i]; // the temp array size
			int size = temp.length;
			
			int start = i;
			int end = n-start-1;
			
			
			for (int k = 0; k < size; ++k) {
				temp[k] = matrix[start][end-k]; // temp <- up
				
				matrix[start][start+k] = matrix[end-k][start]; // up <-
																		// left
				matrix[end-k][start] = matrix[end][end-k]; // left <-
																		// bottom
				matrix[end][end-k] = matrix[start][end]; // bottom
																				// <-
																				// right
				matrix[start][end] = temp[k]; // right <- temp(up)

				System.out.println("(" + (n - i - 1 - k) + "," + i + ")<--"
						+ "(" + i + "," + (n - i - 1 - k) + ")," + "("
						+ (n - i - 1 - k) + "," + i + ")<--" + "("
						+ (n - i - 1) + "," + (i + k) + ")," + "("
						+ (n - i - 1) + "," + (i + k) + ")<--" + "("
						+ (n - i - 1 - k) + "," + (n - i - 1) + ")," + "("
						+ (n - i - 1 - k) + "," + (n - i - 1) + ")<--" + "("
						+ i + "," + (n - i - 1 - k) + ")");
			}
		}
	}

	public static void main(String[] args) {
		RotateImage rotateImage = new RotateImage();
		int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 },
				{ 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		rotateImage.rotate(matrix);
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[0].length; ++j) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
