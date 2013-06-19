package com.xuqin.zproblems;

public class DecodeWays {
	public int numDecodings(String s) {    //pay attention to 0
		if(s==null || s.isEmpty()) {
			return 0;
		} 
		if(s.length()==1) {
			return s.charAt(0)=='0' ? 0 : 1;
		}
		
		int [] result = new int[s.length()];
		
		if(s.charAt(0)=='0') {   //0*
			return 0;
		} else {    //[1-9]*
			if(s.charAt(1)=='0') {  //[1-9]0
				if(s.charAt(0)>'0' && s.charAt(0)<='2') {   //[1|2]0
					result[0]=result[1]=1;
				} else {     //[3-9]0
					return 0;
				}
			} else {   //[1-9][1-9]
				result[0]=1;
				result[1]= (Integer.parseInt(s.substring(0, 2))<=26 ? 2 : 1);
			}
		}
		
		for(int i=2;i<s.length();++i) {
			if(s.charAt(i)=='0') {
				if(s.charAt(i-1)>'0' && s.charAt(i-1)<='2') { //1,2
					result[i] = result[i-2];
				} else {
					return 0;    //(0|3-9)0 : there is no answer
				}
			} else {
				
				if(s.charAt(i-1)=='0') {
					result[i] = result[i-1];
				} else {
					if(Integer.parseInt(s.substring(i-1,i+1))>26) {
						result[i] = result[i-1];
					} else {
						result[i] = result[i-1] + result[i-2];
					}
				}
			}
		}
		
		return result[s.length()-1];
    } 
}
