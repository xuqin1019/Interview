/**
 * 
 */
package com.xuqin.zproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xuqin
 *
 * 
 */
public class WordSearch {
	 public boolean exist(char[][] board, String word) {
		 if(board==null || board.length==0) {
			 return false;
		 }
	     List<Point> startPoints = getStartPoints(board,word.charAt(0));
	     if(startPoints.isEmpty()) {
	    	 return false;
	     }
	     
	     char [][] visited = new char[board.length][board[0].length];
	    
	     
	     for(Point p : startPoints) {
	    	 int x = p.x;
	    	 int y = p.y;
	    	 for(int i=0;i<visited.length;++i) {
		    	 Arrays.fill(visited[i], '0');
		     }
	    	 if(hasWord(visited,board,word,x,y)) {
	    		 return true;
	    	 }
	    }
	     
	    return false;
	 }
	 
	private boolean hasWord(char[][] visited ,char[][] board, String word, int x, int y) {
		if(word.length()==0) {
			return true;
		}
		
		if(x>=board.length || x<0 || y>=board[0].length || y<0 || visited[x][y]=='1' || board[x][y]!=word.charAt(0)) {
			return false;
		} else {    // visited[x][y]=='0' && board[x][y]==word.charAt(0)
			
			visited[x][y]='1';
			
			String subWord = word.substring(1);
			
			if(hasWord(visited,board,subWord, x+1, y)) {
				return true;
			} 
			
			if(hasWord(visited,board,subWord, x, y+1)) {
				return true;
			} 
			
			if(hasWord(visited,board,subWord, x-1, y)) {
				return true;
			} 
			
			if(hasWord(visited,board,subWord, x, y-1)) {
				return true;
			} 
			
			visited[x][y]='0';                      //backtrace
		}
		
		return false;
	
	}

	private List<Point> getStartPoints(char[][] board, char c) {
		List<Point> points = new ArrayList<Point>();
		for(int i=0;i<board.length;++i) {
			for(int j=0;j<board[0].length;++j) {
				if(board[i][j]==c) {
					points.add(new Point(i,j));
				}
			}
		}
		return points;
	}

	static class Point {
		int x;
		int y;
		 
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		 
	 }
	
	public static void main(String[] args) {
		char [][] board = new char[][] {"acccbaabba".toCharArray(),
				                        "bbaacabcac".toCharArray(),
				                        "cbcaababba".toCharArray(),
				                        "accccacccb".toCharArray(),
				                        "abaaaabbac".toCharArray(),
				                        "bababbcbab".toCharArray(),
				                        "aaacaabbcb".toCharArray(),
				                        "ccbaababcb".toCharArray(),
				                        "cacacaccba".toCharArray(),
				                        "abbbccbbaa".toCharArray(),
				                        "ababbacaac".toCharArray(),
				                        "ccbbaacaab".toCharArray(),
				                        "bbacaabcca".toCharArray(),
				                        "acbbcacbaa".toCharArray(),
		};
		WordSearch wordSearch = new WordSearch();
		System.out.println(wordSearch.exist(board, "aaacabbbbaccbb"));
	}
}
