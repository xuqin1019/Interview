/**
 * 
 */
package com.xuqin.zproblems;

/**
 * @author xuqin
 *
 * 
 */
public class ValidPalindrome {
	
	 public boolean isPalindrome(String s) {
		 if(s==null) {
			 return false;
		 } 
		 if(s.equals("")) {
			 return true;
		 }

		 int i=0,j=s.length()-1;
		 
		 while(i<j) {
			 char front = s.charAt(i);
			 char end = s.charAt(j);
			 if(!Character.isLetterOrDigit(front)) {
				 ++i;
			 } else if(!Character.isLetterOrDigit(end)) {
				 --j;
			 } else if(Character.toLowerCase(front)==Character.toLowerCase(end)) {
				 ++i;
				 --j;
			 } else {
				 return false;
			 }
		 }
		 
		 return true;
	 }
}
