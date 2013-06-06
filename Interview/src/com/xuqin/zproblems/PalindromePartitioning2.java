/**
 * 
 */
package com.xuqin.zproblems;

/**
 * @author xuqin
 *
 * 
 */
public class PalindromePartitioning2 {
	public int minCut(String s) {
       if(s==null || s.length()<=1) {
    	   return 0;
       } 
       
       if(isPalindrome(s)) {
    	   return 0;
       }
       
       int [] minCut = new int[s.length()];
       
       for(int i=1;i<s.length();++i) {
    	   
    	   if(isPalindrome(s.substring(0, i+1))) {
    		   minCut[i]=0;
    		   continue;
    	   }
    	   
    	   int min = minCut[i-1] + 1;
    	   for(int k=1;k<i;++k) {
    		   if(isPalindrome(s.substring(k,i+1))) {
    			   min = Math.min(min , minCut[k-1]+1);
    		   }
    	   }
    	   
    	   minCut[i]=min;
       }
       
       return minCut[s.length()-1];
    }

	private boolean isPalindrome(String s) {
		if(s==null || s.length()==0) {
			return false;
		}
		if(s.length()==1) {
			return true;
		}
		int i=0;
		int j=s.length()-1;
		while(i<j) {
			if(s.charAt(i)==s.charAt(j)) {
				i++;
				j--;
			} else {
				return false;
			}
		}
		return true;
	}
}
