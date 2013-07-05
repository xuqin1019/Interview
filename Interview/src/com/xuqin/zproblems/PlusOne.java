/**
 * 
 */
package com.xuqin.zproblems;



/**
 * @author xuqin
 *
 * 
 */
public class PlusOne {
	 public int[] plusOne(int[] digits) {
		 if(digits.length==0) {
			 return digits;
		 }
		 if(digits[digits.length-1]<9) {
			 digits[digits.length-1]+=1;
			 return digits;
		 }
		 digits[digits.length-1]=0;
		 int addition = 1;
		 for(int i=digits.length-2;i>=0;--i) {
			 if(addition!=0) {
				 int value = digits[i];
				 digits[i] = (value+addition)%10;
				 addition = ((value+addition)/10); 
			 } else {
				break; 
			 }
		 }
		 if(addition==1) {
			int [] result = new int[digits.length+1];
			result[0]=1;
			System.arraycopy(digits, 0, result, 1, digits.length);
			return result;
		 }
		 return digits;
	 }
	 
	 public static void main(String[] args) {
		PlusOne plusOne = new PlusOne();
		int [] result = plusOne.plusOne(new int[]{8,9,9,9});
		for(int i=0;i<result.length;++i) {
			System.out.print(result[i]);
		}
	}
}
