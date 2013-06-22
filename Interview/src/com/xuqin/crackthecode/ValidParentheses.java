/**
 * 
 */
package com.xuqin.crackthecode;

/**
 * @author xuqin
 *
 * 
 */
public class ValidParentheses {
	public static void printPar(int count) {
		char [] str = new char[count*2];
		printPar(count,count,str,0);
	}

	
	private static void printPar(int l, int r, char[] str, int count) {   //l , r is the remain number of left and right parenthese 
		// TODO Auto-generated method stub
		if(l<0 || r<l) return;
		if(l==0 && r==0) {
			System.out.println(str);
		} else {
			if(l>0) {
				str[count]='(';
				printPar(l-1, r, str, count+1);
			}
			if(r>l) {
				str[count]=')';
				printPar(l, r-1, str, count+1);
			}
		}
	}
	
	public static void main(String[] args) {
		ValidParentheses.printPar(5);
	}
}
