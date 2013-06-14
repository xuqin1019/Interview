/**
 * 
 */
package com.xuqin.zproblems;

/**
 * @author xuqin
 * 
 * need review
 * 
 */
public class InterleavingString {     
	 public boolean isInterleave(String s1, String s2, String s3) {    //slow , can not pass the large set 
		 if(s3.length()!=(s1.length()+s2.length())) {
			 return false;
		 }
		 if(s1.isEmpty()) {
			 if(s2.equals(s3)) {
				 return true;
			 } else {
				 return false;
			 }
		 }
		 if(s2.isEmpty()) {
			 if(s1.equals(s3)) {
				 return true;
			 } else {
				 return false;
			 }
		 }
		 
		 if((s1.charAt(0)!=s3.charAt(0)) && s2.charAt(0)!=s3.charAt(0)) {
			 return false;
		 }
		 
		 return (s1.charAt(0)==s3.charAt(0) && isInterleave(s1.substring(1), s2, s3.substring(1))) || (s2.charAt(0)==s3.charAt(0) && isInterleave(s1, s2.substring(1), s3.substring(1)));
	 }
	 
	 
	 public boolean isInterleave1(String s1,String s2,String s3) {    //DP (a quick solution)
		 if(s3.length()!=(s1.length()+s2.length())) {
			 return false;
		 }
		 if(s1.isEmpty() && s2.isEmpty() && s3.isEmpty()) {
			 return true;
		 }
		 
		 if(s1.isEmpty()) {
			 return s2.equals(s3);
		 }
		 
		 if(s2.isEmpty()) {
			 return s1.equals(s3);
		 }
		 
		 int [][] results = new int[s1.length()][s2.length()];
		 
		 for(int i=0;i<s1.length();++i) {
			 for(int j=0;j<s2.length();++j) {
				 if(i==0 && j==0) {
					if((s1.substring(0, 1)+s2.substring(0,1)).equals(s3.substring(0,2)) || (s2.substring(0, 1)+s1.substring(0,1)).equals(s3.substring(0,2))) {
						results[i][j]=1;
					}
				 } else if(i==0) {
					 if((s2.charAt(j)==s3.charAt(i+j+1) && results[i][j-1]==1) || (s1.charAt(i)==s3.charAt(i+j+1) && s2.subSequence(0, j+1).equals(s3.substring(0,i+j+1)))) {
						 results[i][j]=1;
					 }
				 } else if(j==0) {
					 if(s1.charAt(i)==s3.charAt(i+j+1) && results[i-1][j]==1 ||  (s2.charAt(j)==s3.charAt(i+j+1) && s1.subSequence(0, i+1).equals(s3.substring(0,i+j+1)))) {
						 results[i][j]=1;
					 }
				 } else if((s1.charAt(i)==s3.charAt(i+j+1) && results[i-1][j]==1) || (s2.charAt(j)==s3.charAt(i+j+1) && results[i][j-1]==1)) {
					 results[i][j]=1;
				 }
			 }
		 }
		 
		 return results[s1.length()-1][s2.length()-1]==1;
	 }
	 
	 public static void main(String[] args) {
		 InterleavingString interleavingString = new InterleavingString();
		 System.out.println(interleavingString.isInterleave("aabcc","dbbca","aadbbcbcac"));
		 System.out.println(interleavingString.isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa","babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab","babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"));
	}
}
