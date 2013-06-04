/**
 * 
 */
package com.xuqin.zproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author xuqin
 * BFS (minum path length)
 * 
 */



public class LadderLength {
	public int ladderLength(String start, String end, HashSet<String> dict) {
		List<String> dictList = new ArrayList<String>(dict);
		dictList.add(0, start);
		dictList.add(end);
		int [][] graph = buildGraph(dictList.toArray(new String[1]));
		
		return minPath(graph);
    }
	
	private int minPath(int[][] graph) {
		int size = graph.length;
		int start = 0;
		int step=1;
		int end = graph.length-1;
		
		Queue<Tuple> queue = new LinkedBlockingQueue<Tuple>();
		queue.add(new Tuple(start,step));
		
		while(queue.size()!=0) {
			Tuple tuple = queue.poll();
			
			for(int i=0;i<size;++i) {
				if(graph[tuple.index][i]!=0) {
					queue.add(new Tuple(i,tuple.step+1));
					if(i==end) {
						return tuple.step+1;
					}
				}
			}
		}
		return 0;
	}

	private int[][] buildGraph(String [] words) {
		int [][] graph = new int[words.length][words.length];
		for(int i=0;i<graph.length;++i) {
			Arrays.fill(graph[i], 0);
		}
		
		for(int i=0;i<words.length;++i) {
			for(int j=0;j<words.length;++j) {
				if(oneDiff(words[i],words[j])) {
					graph[i][j]=1;
				}
			}
		}
		return graph;
	}

	private boolean oneDiff(String word1, String word2) {
		if(word1.length()!=word2.length()) {
			return false;
		}
		int diff=0;
		for(int i=0;i<word1.length();++i) {
			if(word1.charAt(i)!=word2.charAt(i)) {
				diff++;
			}
		}
		return diff==1;
	}
	
	class Tuple {
		int index;
		int step;
		
		public Tuple(int index, int step) {
			this.index = index;
			this.step = step;
		}
	}
}
