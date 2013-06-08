/**
 * 
 */
package com.xuqin.zproblems;

/**
 * @author xuqin
 *
 * 
 */
public class SurroundedRegions {
	public void solve(char[][] board) {
		if(board==null || board.length==0) {
			return;
		}
		
		int x = board.length;
		int y = board[0].length;
		
		for(int i=0;i<x;++i) {
			travel(i,0,board);
			travel(i,y-1,board);
		}
		
		for(int j=1;j<y-1;++j) {
			travel(0,j,board);
			travel(x-1,j,board);
		}
		
		for(int i=0;i<x;++i) {
			for(int j=0;j<y;++j) {
				if(board[i][j]=='O') {
					board[i][j]='X';
				} else if(board[i][j]=='D') {
					board[i][j]='O';
				}
				
			}
		}
    }

	
	private void travel(int startX,int startY, char[][] board) {
		if(startX>=board.length || startX<0 || startY>=board[0].length || startY<0 || board[startX][startY]!='O') {
			return;
		}
		if(board[startX][startY]=='O') {
			board[startX][startY]='D';
			travel(startX+1, startY, board);
			travel(startX-1, startY, board);
			travel(startX, startY+1, board);
			travel(startX, startY-1, board);
		}
	}
	
	public static void main(String[] args) {
		SurroundedRegions surroundedRegions = new SurroundedRegions();
		char [][] board = new char[][]{{'X','X','X','X','X','X'},{'X','O','O','X','O','X'},{'X','X','O','X','X','X'},{'X','O','X','X','O','X'}};
		surroundedRegions.solve(board);
		for(int i=0;i<board.length;++i) {
			for(int j=0;j<board[0].length;++j) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}
