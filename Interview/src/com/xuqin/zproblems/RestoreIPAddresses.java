/**
 * 
 */
package com.xuqin.zproblems;

import java.util.ArrayList;

/**
 * @author xuqin
 *  
 *  similar to AllMutation
 * 
 */
public class RestoreIPAddresses {
	public ArrayList<String> restoreIpAddresses(String s) {
		return restoreIpAddresses(s,3);
	}

	private ArrayList<String> restoreIpAddresses(String s, int num) {
		 ArrayList<String> results = new ArrayList<String>();
		 
		 //base line
		 if(s.length()==1 && num>=2) {
			 return results;
		 }
		 if(num==0) {
			 if(s.length()==1) {
				 results.add(s);
				 return results;
			 } else if(s.length()>1 && s.length()<=3) {
				 if(!s.startsWith("0") && Integer.parseInt(s)<=255) {
					 results.add(s);
					 return results;
				 }
			 } else {
				 return results;
			 }
		 }
		 
		 for(int i=0;i<Math.min(3, s.length());++i) {
			 String candidate = s.substring(0,i+1);
			 if(candidate.equals("0") || (!candidate.startsWith("0") && Integer.parseInt(candidate)<=255)) {
				 ArrayList<String> partResults = restoreIpAddresses(s.substring(i+1), num-1); 
				 ArrayList<String> part = new ArrayList<String>();
				 for(String str : partResults) {
					 part.add(candidate+"."+str);
				 }
				 results.addAll(part);
			 }
		 }
		 return results;
	}
	
	public static void main(String[] args) {
		RestoreIPAddresses restoreIPAddresses = new RestoreIPAddresses();
		//System.out.println(restoreIPAddresses.restoreIpAddresses("25525511135"));
		System.out.println(restoreIPAddresses.restoreIpAddresses("010010"));
		System.out.println();
	}
}

//	["0.10.0.10","0.100.1.0"]
