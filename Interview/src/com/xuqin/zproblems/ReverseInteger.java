/**
 * 
 */
package com.xuqin.zproblems;

/**
 * @author xuqin
 *
 * 
 */
public class ReverseInteger {
	public int reverse(int x) {
		if(x==0) {
			return 0;
		}
		String str = String.valueOf(x);
		int sign = str.charAt(0)=='-' ? -1 : 1;
		str =  str.charAt(0)=='-' ? str.substring(1) : str;
		StringBuilder sb = new StringBuilder();
		boolean isSerialZero = true;
		for(int i=str.length()-1;i>=0;--i) {
			if(isSerialZero && str.charAt(i)=='0') {
				continue;
			}
			sb.append(str.charAt(i));
			if(isSerialZero) {
				isSerialZero = false;
			}
		}
		return Integer.parseInt(sb.toString())*sign;
    }
}
