/**
 * 
 */
package com.xuqin.zproblems;

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
		
		for(int i=2;i<=length;++i) {
			int maxTemp = prices[i-1];
			for(int k=1;k<=i/2;++k) {
				int temp = result[k] + result[i-k];
				if(temp>maxTemp) {
					maxTemp = temp;
				}
			}
			result[i] = maxTemp;
		}
		return result[length];
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
