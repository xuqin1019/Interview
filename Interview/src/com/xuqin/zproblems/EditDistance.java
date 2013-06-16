/**
 * 
 */
package com.xuqin.zproblems;

/**
 * @author xuqin
 *
 * 
 */
public class EditDistance {
	public int minDistance(String word1, String word2) {
		if(word1.isEmpty() && word2.isEmpty()) {
			return 0;
		} else if(word2.isEmpty()) {
			return word1.length();
		} else if(word1.isEmpty()) {
			return word2.length();
		}
		
		
		
		int [][] array = new int[word1.length()][word2.length()];
		if(word1.charAt(0) == word2.charAt(0)) {
			array[0][0] = 0;
		} else {
			array[0][0] = 1;
		}
 		for(int i=1;i<word2.length();++i) {
			if(word1.charAt(0)==word2.charAt(i)) {
				array[0][i]=i;
			} else {
				array[0][i]=array[0][i-1]+1;
			}
		}
		
		for(int i=1;i<word1.length();++i) {
			if(word1.charAt(i)==word2.charAt(0)) {
				array[i][0]=i;
			} else {
				array[i][0]=array[i-1][0]+1;
			}
 		}
		
		for(int i=1;i<word1.length();++i) {
			for(int j=1;j<word2.length();++j) {
				if(word1.charAt(i)==word2.charAt(j)) {
					array[i][j] = array[i-1][j-1];
				} else {
					array[i][j] = Math.min(array[i-1][j-1],Math.min(array[i][j-1],array[i-1][j]))+1;
				}
			}
		}
//		for(int i=0;i<word2.length();++i) {
//			System.out.print("\t" + word2.charAt(i));
//		}
//		System.out.println();
//		for(int i=0;i<word1.length();++i) {
//			System.out.print(word1.charAt(i)+"\t");
//			for(int j=0;j<word2.length();++j) {
//				System.out.print(array[i][j]+"\t");
//			}
//			System.out.println();
//		}
		
		return array[word1.length()-1][word2.length()-1];
    }
	
	public static void main(String[] args) {
		EditDistance editDistance = new EditDistance();
		System.out.println(editDistance.minDistance("pneumonoultramicroscopicsilicovolcanoconiosis", "ultramicroscopically"));
		
	}
}
