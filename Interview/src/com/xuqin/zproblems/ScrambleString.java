package com.xuqin.zproblems;

public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
		if(s1.equals(s2)) {
			return true;
		}
		
		if(s1.length()!=s2.length()) {
			return false;
		} else {
			if(s1.length()==1) {
				return s1.equals(s2);
			} else if(s1.length()==2) {
				return (s1.charAt(0)==s2.charAt(1) && s1.charAt(1)==s2.charAt(0));
			}
		}

		for(int i=1;i<s1.length();++i) {
			boolean result = isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i, s1.length()), s2.substring(i, s2.length()));
			result = result || (isScramble(s1.substring(0,i),s2.substring(s2.length()-i,s2.length())) && (isScramble(s1.substring(i,s1.length()), s2.substring(0, s2.length()-i))));
			if(result) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		ScrambleString scrambleString = new ScrambleString();
		System.out.println(scrambleString.isScramble("abcdefghijklmnopq", "efghijklmnopqcadb"));
	}
}
