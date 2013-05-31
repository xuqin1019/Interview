package com.xuqin.polynomial;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PolyCalTest {
	
	private PolynomialArray polynomialArray1;
	private PolynomialArray polynomialArray2;
	
	@Before
	public void init() {
		polynomialArray1 = new PolynomialArray();
		polynomialArray2 = new PolynomialArray();
		Item[] Items1 = new Item[] {new Item(10, 1000),new Item(5, 14),new Item(1, 0)};
		Item[] items2 = new Item[] {new Item(3, 1990),new Item(-2, 1492),new Item(11, 1),new Item(5, 0)};
		polynomialArray1.init(Items1);
		polynomialArray2.init(items2);
	}
	
	@Test
	public void testCal() {
		Item[] addItems = new Item[] {new Item(3, 1990),new Item(10, 1000),new Item(-2, 1492),new Item(5, 14),new Item(11, 1),new Item(6, 0)};
		Item[] multiItems = new Item[] {new Item(30, 2990),new Item(-20, 2492),new Item(15, 2004),new Item(3, 1990),new Item(-10, 1506),new Item(-2, 1492),new Item(110, 1001),new Item(50, 1000),new Item(55, 15),new Item(25, 14),new Item(11, 1),new Item(5, 0)};
		assertEquals(12, multiItems.length);
		PolynomialArray addPolynomialArray = PolyCal.add(polynomialArray1,polynomialArray2);
		assertEquals(1990, addPolynomialArray.highPower);
		PolynomialArray multiPolynomialArray = PolyCal.multi(polynomialArray1, polynomialArray2);
		assertEquals(addPolynomialArray, new PolynomialArray(addItems));
		assertEquals(multiPolynomialArray, new PolynomialArray(multiItems));
	}
}
