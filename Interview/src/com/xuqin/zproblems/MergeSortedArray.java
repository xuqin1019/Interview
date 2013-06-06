/**
 * 
 */
package com.xuqin.zproblems;

/**
 * @author xuqin
 *
 * 
 */
public class MergeSortedArray {
//	public void merge(int A[], int m, int B[], int n) {
//		int [] sortedArray = new int[m+n];
//		int i=0,j=0,k=0;
//		while(i<m && j<n) {
//			if(A[i]<=B[j]) {
//				sortedArray[k++] = A[i++];
//			} else {
//				sortedArray[k++] = B[j++];
//			}
//		}
//		if(i==m) {
//			while(k<m+n) {
//				sortedArray[k++] = B[j++];
//			}
//		}
//		
//		if(j==n) {
//			while(k<m+n) {
//				sortedArray[k++] = B[i++];
//			}
//		}
//		
//		for(int l=0;l<m+n;++l) {
//			A[l] = sortedArray[l];
//		}
// 	}
	
	public void merge(int A[], int m, int B[], int n) {

	    while(n>0){
	        if(m <=0 || A[m-1] < B[n-1])
	            A[n+m-1] = B[--n];
	        else
	            A[n+m-1] = A[--m];
	    }
	}
	
}
