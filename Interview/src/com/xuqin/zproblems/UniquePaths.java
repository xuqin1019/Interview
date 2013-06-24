package com.xuqin.zproblems;

public class UniquePaths {
	public int uniquePaths(int m, int n) {     //time exceeded on large data set
		Sum sum = new Sum(0);
		uniquePaths(0,0,m-1,n-1,sum);
		return sum.sum;
    }

	private void uniquePaths(int i, int j, int m, int n,Sum sum) {
		if(i==m && j==n) {
			sum.add();
			return;
		}
		
		if(i<0 || i>m || j<0 || j>n) {
			return;
		}
		
		uniquePaths(i+1, j,m,n,sum);
		uniquePaths(i, j+1,m,n,sum);
	}
	
	static class Sum {
		int sum = 0;
		public Sum(int sum) {
			this.sum = sum;
		}
		
		public void add() {
			sum++;
		}
	}
	
	
	public int uniquePathsImp(int m, int n) {
		int [][] num = new int[m][n];
		for(int i=0;i<num.length;++i) {
			num[i][0]=1;
		}
		
		for(int i=0;i<num[0].length;++i) {
			num[0][i]=1;
		}
		
		for(int i=1;i<num.length;++i) {
			for(int j=1;j<num[0].length;++j) {
				num[i][j] = num[i-1][j] + num[i][j-1];
			}
		}
		
		return num[m-1][n-1];
	} 
	
	public static void main(String[] args) {
		UniquePaths uniquePaths = new UniquePaths();
		System.out.println(uniquePaths.uniquePaths(4, 8));
		System.out.println(uniquePaths.uniquePathsImp(4, 8));
	}
}
