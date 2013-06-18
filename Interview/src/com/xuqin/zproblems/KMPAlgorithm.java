/**
 * 
 */
package com.xuqin.zproblems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuqin
 *
 * 
 */
public class KMPAlgorithm {
	public List<Integer> kmpSearch(String text,String pattern) {
		List<Integer> results = new ArrayList<Integer>();
		
		int [] lps = computeLPSArray(pattern);
		
		//slip num = num of already match - LPS[last index of match char in pattern]
		int i=0,j=0;
		while(i<text.length()) {    //don't need to move text string
			if(text.charAt(i)==pattern.charAt(j)) {
				++i;
				++j;
				
				if(j==pattern.length()) {
					results.add(i-j);                  //add the result
					j=lps[j-1];
				}
			} else {
				if(j!=0) {   
					// Do not match lps[0..lps[j-1]) characters,   
			        // they will match anyway
					j=lps[j-1];
				} else {
					i++;
				}
			}
		}
		
		return results;
	}
	
	
	
	private int[] computeLPSArray(String pattern) {
		int [] lps = new int[pattern.length()];
		lps[0]=0;
		int lastIndex = 0;
		for(int i=1;i<lps.length;++i) {
			if(pattern.charAt(i)==pattern.charAt(lastIndex)){
				lps[i] = lps[i-1]+1;
				lastIndex = lps[i];
			} else {
				lps[i] = 0;
				lastIndex = 0;
			}
		} 
		return lps;
	}
	
	public static void main(String[] args) {
		KMPAlgorithm kmpAlgorithm = new KMPAlgorithm();
		System.out.println(kmpAlgorithm.kmpSearch("AABAACAADAABAAABAA", "AABA"));
	}
}
