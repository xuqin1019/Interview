package com.xuqin.zproblems;

import java.util.ArrayList;

public class GenerateParentheses {
	public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        generateParenthesis(n,n,0,result,sb);
        return result;
    }

	private boolean generateParenthesis(int l, int r, int pos,ArrayList<String> result,StringBuffer sb) {
		if(l>r || l<0 || r<0) {
			return false;
		}
		
		if(l==0 && r==0) {
			result.add(sb.toString());
			return true;
		} 
		
		sb.append('(');
		generateParenthesis(l-1, r, pos+1,result,sb);
			
		sb.deleteCharAt(sb.length()-1);
		
		sb.append(')');
		generateParenthesis(l, r-1, pos+1, result,sb);
		sb.deleteCharAt(sb.length()-1);
		return false;
	}
	
	public static void main(String[] args) {
		GenerateParentheses generateParentheses = new GenerateParentheses();
		ArrayList<String> result = generateParentheses.generateParenthesis(3);
		for(String str : result) {
			System.out.println(str);
		}
	}
}
