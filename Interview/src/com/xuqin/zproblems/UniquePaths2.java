package com.xuqin.zproblems;


public class UniquePaths2 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int [][] num = new int[obstacleGrid.length][obstacleGrid[0].length];
		
		if(obstacleGrid[0][0]==1) {
			return 0;
		}
		
		num[0][0]=1;
		
		for(int i=1;i<num.length;++i) {
			//num[i][0] = obstacleGrid[i][0]==1 ? -1 : 1;
			if(obstacleGrid[i][0]==1) {
				num[i][0]=-1;
			} else {
				if(num[i-1][0]!=-1) {
					num[i][0]=1;
				} else {
					num[i][0]=-1;
				}
			}
			
		}
		
		for(int j=1;j<num[0].length;++j) {
			//num[0][j] = obstacleGrid[0][j]==1 ? -1 : 1;
			if(obstacleGrid[0][j]==1) {
				num[0][j]=-1;
			} else {
				if(num[0][j-1]!=-1) {
					num[0][j]=1;
				} else {
					num[0][j]=-1;
				}
			}
		}
		
		for(int i=1;i<num.length;++i) {
			for(int j=1;j<num[0].length;++j) {
				if(obstacleGrid[i][j]!=1) {
					int fromLeft = obstacleGrid[i][j-1] == 1 ? -1 : num[i][j-1];
					int fromUp = obstacleGrid[i-1][j] == 1 ? -1 : num[i-1][j];
					
					if(fromLeft==-1 && fromUp==-1) {
						num[i][j]=-1;
					} else {
						num[i][j] += (fromLeft>=0 ? fromLeft : 0);
						num[i][j] += (fromUp>=0 ? fromUp : 0);
					}
					
				} else {
					num[i][j]=-1;
				}
			} 
		}
		
		return num[num.length-1][num[0].length-1] == -1 ? 0 : num[num.length-1][num[0].length-1];
    }
	
	
	public static void main(String[] args) {
		UniquePaths2 uniquePaths2 = new UniquePaths2();
		int [][] obstacleGrid = new int [][] {{0}};
		System.out.println(uniquePaths2.uniquePathsWithObstacles(obstacleGrid));
	}
}
