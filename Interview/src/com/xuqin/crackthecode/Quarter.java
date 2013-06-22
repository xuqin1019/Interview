/**
 * 
 */
package com.xuqin.crackthecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuqin
 *
 * 
 */
public class Quarter {
	//25,10,5,1
	public static boolean numOfWays(int n,List<Integer> result,int upBounder) {
		if(n==0) {
			return true;
		} else if(n<0) {
			return false;
		} else {
			List<Integer> lists = getUpBounder(upBounder);
			for(int value : lists) {
				if(numOfWays(n-value, result,value)) {
					result.set(0, result.get(0)+1);
				}
			}
			return false;
		}
	}
	
	
	private static List<Integer> getUpBounder(int upBounder) {
		List<Integer> list = new ArrayList<Integer>();
		if(upBounder>=25) {
			list.add(25);
		}
		
		if(upBounder>=10) {
			list.add(10);
		} 
		
		if(upBounder>=5) {
			list.add(5);
		}
		
		if(upBounder>=1) {
			list.add(1);
		}
		
		return list;
	}

	public static int numOfWays(int n) {
		List<Integer> result = new ArrayList<Integer>();
		result.add(0);
		numOfWays(n,result,n);
		return result.get(0);
	}
	
	
	public static int makeChange(int n,int denom) {
		int next_denom=0;
		switch (denom) {
		case 25:
			next_denom=10;
			break;
		case 10:
			next_denom=5;
			break;
		case 5:
			next_denom=1;
			break;
		case 1:
			return 1;
		}
		
		int ways = 0;
		for(int i=0;i*denom<=n;++i) {
			ways+=makeChange(n-i*denom, next_denom);
		}
		return ways;
	}
	
	
	public static void main(String[] args) {
		System.out.println(numOfWays(80));
		System.out.println(makeChange(80, 25));
	}
}
