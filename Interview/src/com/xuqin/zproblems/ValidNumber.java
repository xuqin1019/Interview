/**
 * 
 */
package com.xuqin.zproblems;

/**
 * @author xuqin
 *
 * 
 */
public class ValidNumber {
	 public boolean isNumber(String s) {
		 s = s.trim();
		 if(s.startsWith("+") || s.startsWith("-")) {
			 s = s.substring(1);
			 if(s.startsWith("+") || s.startsWith("-")) {
				 return false;
			 }
		 }
		
		 if(s.indexOf('e')==-1) { //not contain e 
			 if(s.indexOf('.')==-1) {   //not contain .
				 return isInteger(s);
			 } else {    //contain .
				 return isFloat(s);
			 }
		 } else {
			 String prePart = s.substring(0, s.indexOf('e'));
			 String PolyPart = s.substring(s.indexOf('e')+1);
			 if(prePart.endsWith(" ") || PolyPart.startsWith(" ")) {   //have space around e
				 return false;
			 }
			 return isFloat(prePart) && isInteger(PolyPart);
		 }
	 }

	
	private boolean isFloat(String floatPart) {
		if(floatPart.startsWith(" ")) {    //can not start with space
			return false;
		}
		if(floatPart.endsWith("f")) {   //cannot end with f
			return false;
		}
		try {
			Float.parseFloat(floatPart);
		} catch(NumberFormatException e) {
			return false;
		}
		return true;
	}

	private boolean isInteger(String s) {
		if(s.startsWith("+") || s.startsWith("-")) {   //strip the +/-
			s = s.substring(1);
		}
		try {
			Long.parseLong(s);
		} catch(NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		ValidNumber validNumber = new ValidNumber();
		System.out.println(validNumber.isNumber("-8115 e957"));
		System.out.println(validNumber.isNumber(" 005047e+6"));
		System.out.println(validNumber.isNumber("+3. e04116"));
		System.out.println(validNumber.isNumber("1.38354e+8"));
		System.out.println(validNumber.isNumber("959440.94f"));
		System.out.println(validNumber.isNumber(".85e+72041"));
		System.out.println(validNumber.isNumber("2945e+2553"));
		System.out.println(validNumber.isNumber("51007e+28440985"));
		System.out.println(validNumber.isNumber("56614440300046e+1686"));
		System.out.println(validNumber.isNumber("56e+9"));
	}
}
