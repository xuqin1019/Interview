/**
 * 
 */
package com.xuqin.zproblems;

/**
 * @author xuqin
 *
 * 
 */
public class JumpGame {
	public boolean canJump(int[] A) {
		if(A.length==0) {
			return false;
		} else if(A.length==1) {
			return true;
		}
		int i=0;
		while(A[i]<A.length-i-1) {
			int maximumStep = A[i];
			int nextStep = 0;
			int nextIndex = i;
			for(int step = 1;step<=maximumStep;++step) {
				if(step+A[i+step]> nextStep) {
					nextStep = step+A[i+step];
					nextIndex = i+step;
				} 
			}
			i=nextIndex;
			
			if(A[i]==0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		JumpGame jumpGame = new JumpGame();
		System.out.println(jumpGame.canJump(new int[]{1,2,3}));
	}
}
