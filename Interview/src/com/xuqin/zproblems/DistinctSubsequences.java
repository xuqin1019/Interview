package com.xuqin.zproblems;


/**
 * @author Xuqin
 *LeetCode     f[i][j] means the numDistinct of S[0:i],T[0:j]     
 * f[i][j] = f[i-1][j]                 S[i]!=T[j]
 *         = f[i-1][j-1]+f[i-1][j]     S[i]==T[j]
 *
 */
public class DistinctSubsequences {
	public int numDistinct(String S, String T) {   //T in S
		
		if(S.length()<T.length()) {
			return 0;
		}
		
		int [] numDistinct = new int[T.length()];
		
		int [] preNumDistince = new int[T.length()];
		if(T.charAt(0)==S.charAt(0)) {
			numDistinct[0]=1;
			preNumDistince[0]=1;
		} 
		
		for(int i=1;i<S.length();++i) {
			for(int j=0;j<T.length();++j) {
				if(T.charAt(j)==S.charAt(i)) {
					if(j==0) {
						numDistinct[j] = preNumDistince[j]+1;
					} else {
						numDistinct[j] = preNumDistince[j-1]+preNumDistince[j];
					}
				} else {
					numDistinct[j] = preNumDistince[j];
				}
			}
			System.arraycopy(numDistinct, 0, preNumDistince,0,numDistinct.length);
		}
		return numDistinct[numDistinct.length-1];
	}
	
	public static void main(String[] args) {
		DistinctSubsequences distinctSubsequences = new DistinctSubsequences();
		System.out.println(distinctSubsequences.numDistinct("rabbbit", "rabbit"));
	}
}
