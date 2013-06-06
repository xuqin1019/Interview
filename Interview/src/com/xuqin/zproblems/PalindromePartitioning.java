/**
 * 
 */
package com.xuqin.zproblems;

import java.util.ArrayList;

/**
 * @author xuqin
 *LeetCode (Palindrome Partitioning)
 * 
 */
public class PalindromePartitioning {
	public ArrayList<ArrayList<String>> partition(String s) {
		if(s==null || s.length()==0) {
			return new ArrayList<ArrayList<String>>();
		}
		
        ArrayList<ArrayList<String>> results = palindrome(s, 0, s.length());
        return results;
    }
	
	public ArrayList<ArrayList<String>> palindrome(String s,int start,int end) {
		ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
		
		if(end-start==1) {    //single character
			ArrayList<String> result = new ArrayList<String>();
			result.add(s.substring(start,end));
			results.add(result);
			return results;
		}
		
		if(start==end) {
			results.add(new ArrayList<String>());
			return results;
		}
		
		for(int i=start;i<=end;++i) {
			String frontStr = s.substring(start, i);
			if(isPalindrome(frontStr)) {
				ArrayList<ArrayList<String>> temp = palindrome(s, i, end);
				for(ArrayList<String> subPa : temp) {
					subPa.add(0,frontStr);
					results.add(subPa);               ////
				}
				
			}
		}
		
		return results;
	}

	/**
	 * @param frontStr
	 * @return true is str is palindrome
	 */
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
	
	public static void main(String[] args) {
		PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
		String s = "aabaa";
		ArrayList<ArrayList<String>> results = palindromePartitioning.palindrome(s, 0, s.length());
	//	System.out.println(results.size());
		for(ArrayList<String> list : results) {
			System.out.println(list.toString());
		}
		
	//	System.out.println("hello " + "xuqin".substring(0,0));
	}
}
