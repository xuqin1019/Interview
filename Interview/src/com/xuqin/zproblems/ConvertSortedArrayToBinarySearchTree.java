package com.xuqin.zproblems;

public class ConvertSortedArrayToBinarySearchTree {
	
	 public TreeNode sortedArrayToBST(int[] num) {
		 if(num==null || num.length==0) {
			 return null;
		 }
		 return sortedArrayToBST(num,0,num.length-1);
	 }
	
	
	private TreeNode sortedArrayToBST(int[] num, int start, int end) {
		if(start>end) {
			return null;
		}
		int middle = start+(end-start)/2;
		TreeNode root = new TreeNode(num[middle]);
		root.left = sortedArrayToBST(num, start, middle-1);
		root.right = sortedArrayToBST(num, middle+1, end);
		return root;
	}


	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		ConvertSortedArrayToBinarySearchTree convertSortedArrayToBinarySearchTree = new ConvertSortedArrayToBinarySearchTree();
		
		int [] num = new int[]{1,2,3,4,5,6,7,8,9,10};
		
		TreeNode treeNode = convertSortedArrayToBinarySearchTree.sortedArrayToBST(num);
		
	}
}
