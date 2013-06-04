/**
 * 
 */
package com.xuqin.zproblems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuqin
 *
 *  DP 
 */
public class CuttingRod {
	
	public int maxPrice(int [] prices) {
		
		if(invalidInput(prices)) {
			throw new IllegalArgumentException("error exception");
		}
		
		if(prices.length==0) {
			return 0;
		}
		
		int length = prices.length;
		int [] result =  new int[length+1];
		result[1]=prices[0];
		Map<Integer,String> maps = new HashMap<Integer,String>();
		maps.put(1, "p1");
		
		for(int i=2;i<=length;++i) {
			int maxTemp = prices[i-1];
			maps.put(i, "p"+i);
			for(int k=1;k<=i/2;++k) {
				int temp = result[k] + result[i-k];
				if(temp>maxTemp) {
					maxTemp = temp;
					maps.put(i, "f"+k + " " +"f"+(i-k));
				}
			}
			result[i] = maxTemp;
		}
		
		PrintResult(maps,length);
		System.out.println();
		return result[length];
	}

	/**
	 * @param maps
	 */
	private void PrintResult(Map<Integer, String> maps,int length) {
		String value = maps.get(length);
		print(maps,value);
	}

	/**
	 * @param value
	 */
	private void print(Map<Integer, String> maps,String value) {
		String Items[] = value.split(" ");
		if(Items.length==1 && value.startsWith("p")) {
			System.out.print(value);
			return;
		}
		for(String item : Items) {
			print(maps,maps.get(Integer.parseInt(item.substring(1))));
		}
	}

	/**
	 * @param prices
	 * @return
	 */
	private boolean invalidInput(int[] prices) {
		if(prices == null) {
			return true;
		}
		
		if(prices.length==0) {
			return false;
		}
		
		int tempMax = prices[0];
		
		for(int i=1;i<prices.length;++i) {
			if(prices[i] < tempMax) {
				return true;
			}
			tempMax=prices[i];
		}
		return false;
	}
}
