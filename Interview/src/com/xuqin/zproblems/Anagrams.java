/**
 * 
 */
package com.xuqin.zproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author xuqin
 *
 * 
 */
public class Anagrams {
	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> results = new ArrayList<String>();
		Map<String,List<String>> map = new HashMap<String, List<String>>();
		for(String word : strs) {
			String mapWord = getMapWord(word);
			if(map.get(mapWord)==null) {
				List<String> list = new ArrayList<String>();
				map.put(mapWord, list);
			}
			map.get(mapWord).add(word);
		}
		for(List<String> list : map.values()) {
			if(list.size()>1) {
				results.addAll(list);
			}
		}
		return results;
	}

	
	private String getMapWord(String word) {
		char [] chars = new char[word.length()];
		for(int i=0;i<word.length();++i) {
			chars[i] = word.charAt(i);
		}
		Arrays.sort(chars);
		return new String(chars);
	}
}
