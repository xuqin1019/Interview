/**
 * 
 */
package com.xuqin.zproblems;

/**
 * @author xuqin
 *
 * 
 */
public class Power {
	 public double pow(double x, int n) {
		 if(n==0) {
			 return 1;
		 }
		 
		 if(x==0) {
			 return 0;
		 }

		 if(n<0) {
			 return 1.0/powOfPositive(x, -n);
		 } else {
			 return powOfPositive(x, n);
		 }
		 
	 }
	 
	 public double powOfPositive(double x , int n) {
		 if(n==0) {
			 return 1;
		 }
		 double half = pow(x, n/2);
		 if(n%2==0) {
			 return half*half;
		 } else {
			 return half*half*x;
		 }
	 }
	 
	 double pow1(double x, int n) {
		    if (n == 0) return 1.0;
		    // Compute x^{n/2} and store the result into a temporary
		    // variable to avoid unnecessary computing
		    double half = pow(x, n / 2);
		    if (n % 2 == 0)
		        return half * half;
		    else if (n > 0)
		        return half * half * x;
		    else
		        return half * half / x;
	 }
	 
	 public static void main(String[] args) {
		Power power = new Power();
		System.out.println(power.pow(0.00001, 2147483647));
	}
}
