/**
 * 
 */
package com.xuqin.zproblems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuqin
 *
 * 
 */
public class LongestSubstringWithoutRepeatingCharacters {
	 public int lengthOfLongestSubstring(String s) {
		 if(s==null || s.length()==0) {
			 return 0;
		 }
		 int max =  0;
		 int [] table = new int[26];
		 Map<Character,Integer> indexes = new HashMap<Character, Integer>();
		 int start = 0;
		 
		 for(int i=0;i<s.length();++i) {
			 Character c = s.charAt(i);
			 if(table[c-'a']==0) {     //not exists
				 table[c-'a']=1;
				 indexes.put(c, i);
				 max = Math.max(max,i-start+1);
			 } else {              //exists
				 
				 start = indexes.get(c)+1;
				 
				 for(int m=0;m<start;++m) {
					 table[s.charAt(m)-'a']=0;
				 }
				 
				 for(int m=start;m<=i;++m) {
					 table[s.charAt(m)-'a']=1;
				 }
				 
				 indexes.put(c, i);
				 
				 max = Math.max(max,i-start+1);
			 }
		 }
		 
		 return max;
	 }
	 
	 public static void main(String[] args) {
		 LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
		 System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("bbbbb"));
	 }
}
