/**
 * 
 */
package com.xuqin.zproblems;

import java.util.Stack;

/**
 * @author xuqin
 *
 * 
 */
public class Stock2 {
	public int maxProfit(int[] prices) {
		if(prices==null || prices.length==1) {
			return 0;
		}
		
		int maxProfit=0;
        Stack<Integer> buyCandidate = new Stack<Integer>();
        Stack<Integer> sellCandidate = new Stack<Integer>();
        buyCandidate.push(prices[0]);
        
        for(int i = 1;i<prices.length;++i) {
        	int currentPrice = prices[i];
        	
        	if(buyCandidate.isEmpty()) {     //first buy it before you can sell
        		buyCandidate.push(currentPrice);
        	} else {   //you already have a buy candidate
        		if(sellCandidate.isEmpty()) {
        			if(currentPrice < buyCandidate.peek()) {  //buy at a lower price if no sell candidate
        				buyCandidate.pop();
            			buyCandidate.push(currentPrice);
        			} else {
        				sellCandidate.add(currentPrice);
        			}
        		} else { //sell at a higher price
        			if(currentPrice > sellCandidate.peek()) { //currentPrice > sellCandidate 
    					sellCandidate.pop();
    					sellCandidate.push(currentPrice);
    				} else {
    				//	System.out.println("(" + buyCandidate.peek()+","+ sellCandidate.peek() +")");
    					maxProfit += (sellCandidate.pop()-buyCandidate.pop());
    					if(buyCandidate.isEmpty()) {     //first buy it before you can sell
    		        		buyCandidate.push(currentPrice);
    		        	}
    				}
        		}
        	}
        }
        
        if(!buyCandidate.isEmpty() && !sellCandidate.isEmpty()) {
        	maxProfit += (sellCandidate.pop()-buyCandidate.pop());
        }
		
        return maxProfit;
    }
}
