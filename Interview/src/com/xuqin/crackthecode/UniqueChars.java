/**
 * 
 */
package com.xuqin.crackthecode;

/**
 * @author xuqin
 *
 * 
 */
public class UniqueChars {
	public static boolean isUniqueChars(String str) {
		int checker = 0;
		for(int i=0;i<str.length();++i) {
			int val = str.charAt(i)-'a';
			if((checker & (1<<val))>0) {
				return false;
			}
			checker |= (1<<val);
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(UniqueChars.isUniqueChars("abdacd"));
	}
}
