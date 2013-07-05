/**
 * 
 */
package com.xuqin.zproblems;

import java.util.ArrayList;

/**
 * @author xuqin
 *
 * 
 */
public class TextJustification {
	public ArrayList<String> fullJustify(String[] words, int L) {
		ArrayList<String> result = new ArrayList<String>();
		int i=0;
		while(i<words.length) {
			StringBuffer line = new StringBuffer();
			String word = words[i];
			int length = word.length();
			if(length > L) {
				return null;
			} else {
				line.append(word);
				int remain = L-length;
				int j=i+1;
				for(;j<words.length && remain>=words[j].length()+1;++j) {
					line.append(" "+words[j]);
					remain-=(words[j].length()+1);
				}
				i=j;
			}
			if(i==words.length) {   //last line
				result.add(line.toString()+padEmpty(L-line.length()));
			} else {
				result.add(justifyLine(line.toString(),L)); 
			}
		}
		return result;
    }

	private String justifyLine(String line,int L) {
		String [] words = line.trim().split(" ");
		int numOfWords  = words.length;
		if(numOfWords==1) {
			StringBuffer sb = new StringBuffer(line);
			sb.append(padEmpty(L-line.length()));
			return sb.toString();
		}
		int remainEmpty = L-line.trim().length();
		if(remainEmpty==0) {
			return line;
		}
		StringBuffer sb = new StringBuffer();
		int eachPad = remainEmpty/(numOfWords-1);
		int addition = remainEmpty%(numOfWords-1);
		for(int i=0;i<addition;++i) {
			sb.append(words[i]);
			sb.append(padEmpty(eachPad+2));
		}
		for(int i=addition;i<numOfWords-1;++i) {
			sb.append(words[i]);
			sb.append(padEmpty(eachPad+1));
		}
		sb.append(words[numOfWords-1]);
		return sb.toString();
	}
	
	private String padEmpty(int n) {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<n;++i) {
			sb.append(" ");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		TextJustification textJustification = new TextJustification();
		System.out.println(textJustification.fullJustify(new String [] {"Here","is","an","example","of","text","justification."},16));
	}
}
