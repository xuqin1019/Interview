package com.xuqin.gcd;

public class GCD {
	public static int gcd(int m, int n) {
		if(m<=0 || n<=0 || m<n) {
			System.out.println("error input");
			return -1;
		}
		
		if(n==1) {
			return n;
		}
		
		while(n>0) {
			int r = m%n;
			m=n;
			n=r;
		}
		return m;
	}
}	
