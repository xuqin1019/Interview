/**
 * 
 */
package com.xuqin.zproblems;



/**
 * @author xuqin
 * LeetCode
 * Need Review
 */
public class Stock1 {
	 public int maxProfit(int[] prices) {    //O(n*n) Time limit Exceeded
		 if(prices==null || prices.length==0) {
			 return 0;
		 }
		 
		 int max = 0;
		 for(int i=0;i<prices.length-1;++i) {
			 for(int j=i+1;j<prices.length;++j) {
				 if(prices[j]-prices[i]>max) {
					 max = prices[j]-prices[i];
				 }
			 }
		 }
		 return max;
	 }
	 
	 public int maxProfitDC(int [] prices) {     //O(nlg(n))
		 if(prices==null || prices.length==0) {
			 return 0;
		 }
		 return maxProfitImprove(prices, 0, prices.length-1);
	 }
	 
	public int maxProfitImprove(int [] prices,int start, int end) {
		if(start==end) {
			return 0;
		}
		if(end-start==1) {
			if(prices[end]-prices[start]>0) {
				return prices[end]-prices[start];
			} else {
				return 0;
			}
		}
		int middle = (start+end)/2;  //[start , middle] , [middle+1,end]
		int leftMiddle = Integer.MAX_VALUE;
		for(int i=start;i<=middle;++i) {
			if(prices[i]<leftMiddle) {
				leftMiddle = prices[i];
			}
		}
		int rightMaximum = Integer.MIN_VALUE;
		for(int i=middle+1;i<=end;++i) {
			if(prices[i]>rightMaximum) {
				rightMaximum = prices[i];
			}
		}
		return Math.max(rightMaximum-leftMiddle,Math.max(maxProfitImprove(prices,start,middle),maxProfitImprove(prices,middle+1,end)));
	}
	
	public int maxProfitBest(int[] prices) {    //O(n)

	    if(prices==null || prices.length==0){
	        return 0;
	    }

	    int profit = 0 ; 
	    int min=prices[0];        
	    for(int i = 0 ; i < prices.length;i++){
	        min = Math.min(min,prices[i]);
	        profit = Math.max(profit,prices[i]-min);
	    }

	    return profit;
	}
}
