package com.xuqin.polynomial;

public class PolyCal {
	public static PolynomialArray add(PolynomialArray polynomialArray1,PolynomialArray polynomialArray2) {
		PolynomialArray polynomialArray = new PolynomialArray();
		polynomialArray.highPower=Math.max(polynomialArray1.highPower, polynomialArray2.highPower);
	//	System.out.println(polynomialArray.highPower);
		for(int i=polynomialArray.highPower;i>=0;--i) {
			polynomialArray.array[i] = polynomialArray1.array[i]+polynomialArray2.array[i];
		} 
		return polynomialArray;
	}
	
	public static PolynomialArray multi(PolynomialArray polynomialArray1,PolynomialArray polynomialArray2) {
		PolynomialArray polynomialArray = new PolynomialArray();
		polynomialArray.highPower=polynomialArray1.highPower+polynomialArray2.highPower;
		if(polynomialArray.highPower>PolynomialArray.MaxDegree) {
			System.out.println("error , exceeded the max degree");
			return null;
		}
		
		for(int i=polynomialArray1.highPower;i>=0;--i) {
			for(int j=polynomialArray2.highPower;j>=0;--j) {
				polynomialArray.array[i+j]+=(polynomialArray1.array[i]*polynomialArray2.array[j]);
			}
		}
		return polynomialArray;
	}
}
