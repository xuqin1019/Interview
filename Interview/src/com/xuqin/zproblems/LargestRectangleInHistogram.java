package com.xuqin.zproblems;

import java.util.Arrays;
import java.util.Stack;
/**
 * 
 */

/**
 * @author xuqin
 * 
 * NeedReview
 * 
 */
public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] height) {     //time out
		int maxArea = 0;
		
		for(int i=0;i<height.length;++i) {
			int minHeight = height[i];   //the minimal
			for(int j=i;j<height.length;++j) {
				minHeight = Math.min(minHeight, height[j]);   //the minimal
				int area = minHeight*(j-i+1);
				if(area>maxArea) {
					maxArea = area;
				}
			}
		}
		
		return maxArea;
    }
	
	public int largestRectangleAreaImp(int[] height) {    //from the right boundary(tide) to left 
		int maxArea = 0;
		int start = 0;
		int end = 0;
		while(start < height.length) {
			end = height.length-1;
			for(int i=start+1;i<height.length;++i) {
				if(height[i]<height[i-1]) {
					end = i-1;
					break;
				} 
			}
			
			int minVal = height[end];
			for(int j=end;j>=0;--j) {
				minVal = Math.min(minVal, height[j]);
				maxArea = Math.max(maxArea, minVal*(end-j+1));
			}
			start = end+1;
		}
		
		return maxArea;
	}
	
	public int largestRectangleAreaBest(int [] height) {
		Stack<Integer> stack = new Stack<Integer>();
		int m=0;
		height = Arrays.copyOf(height, height.length+1);
		height[height.length-1] = 0;
		for(int i=0;i<height.length;++i) {
			if(stack.isEmpty() || height[i]>height[stack.peek()]) {
				stack.push(i);
			} else {
				int t = stack.pop();
				m = Math.max(m, height[t]*(stack.isEmpty() ? i : i-stack.peek()-1));
				--i;
			}
		}
		return m;
	}
	
	
	public static void main(String[] args) {
		LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
		System.out.println(largestRectangleInHistogram.largestRectangleArea(new int[]{2,1,5,7,6,3}));
		System.out.println(largestRectangleInHistogram.largestRectangleAreaBest(new int[]{2,1,5,7,6,3}));
	}
}
