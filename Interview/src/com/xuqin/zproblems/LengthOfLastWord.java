/**
 * 
 */
package com.xuqin.zproblems;

public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		s = s.trim();
		if(s.length()==0) {
			return 0;
		}
		String [] strs = s.split("\\s+");
		return strs[strs.length-1].length();
    }
	
	public static void main(String[] args) {
		System.out.println("heo cd ".split(" ").length);
		
	}
}
