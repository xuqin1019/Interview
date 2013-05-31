package com.xuqin.polynomial;

import java.util.Arrays;
import java.util.Collections;



class Item implements Comparable<Item>{
	int value;
	int poly;
	
	public Item(int value, int poly) {
		this.value = value;
		this.poly = poly;
	}

	@Override
	public int compareTo(Item o) {
		return poly-o.poly;
	}
}

public class PolynomialArray {
	public static final int MaxDegree = 2000000;
	int [] array = new int[MaxDegree+1];
	int highPower;
	
	public PolynomialArray() {
		Arrays.fill(array, 0);
		highPower=0;
	}
	
	public PolynomialArray(Item [] items) {
		this();
		this.init(items);
	}
	
	public void init(Item [] items) {
		for(Item item : items) {
			array[item.poly] = item.value;
		}
		this.highPower =  Collections.max(Arrays.asList(items)).poly;
	}

	@Override
	public boolean equals(Object object) {
		// TODO Auto-generated method stub
		if(!(object instanceof PolynomialArray)) {
			return false;
		}
		PolynomialArray polynomialArray1 = (PolynomialArray)object;
		return (this.highPower==polynomialArray1.highPower && Arrays.equals(this.array,polynomialArray1.array));
	}
	
	
}
