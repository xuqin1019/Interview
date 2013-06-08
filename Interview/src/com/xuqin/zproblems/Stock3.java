/**
 * 
 */
package com.xuqin.zproblems;

/**
 * @author xuqin
 *  
 *Need Review 
 * 
 */
public class Stock3 {
	public int maxProfit(int[] prices) {
		if(prices==null || prices.length==0) {
			return 0;
		}
		int maxProfit = 0;
		
		int [] maxProfitFront = new int[prices.length];
		int [] maxProfitEnd = new int[prices.length];
		
		int profit = 0;
		int min = prices[0];
		for(int i=0;i<prices.length;++i) {
			min = Math.min(min, prices[i]);
			profit = Math.max(profit, prices[i]-min);
			maxProfitFront[i] = profit;
		}
		
		profit = 0;
		int max = prices[prices.length-1];
		for(int i=prices.length-1;i>0;i--) {
			max = Math.max(max, prices[i]);
			profit = Math.max(profit, max-prices[i]);
			maxProfitEnd[i] = profit;
		}
		
		for(int j=0;j<prices.length;++j) {
			maxProfit = Math.max(maxProfit, maxProfitFront[j]+maxProfitEnd[j]);
		}
		return maxProfit;
	}
}
