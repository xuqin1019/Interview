/**
 * 
 */
package com.xuqin.zproblems;

/**
 * @author xuqin
 *
 * 
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder==null || inorder.length==0) {
			return null;
		}
		return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
	}
	  
	private TreeNode buildTree(int[] inorder, int i, int j, int[] postorder,int m, int n) {
		if(i>j) {
			return null;
		}
		int rootValue = postorder[n];
		int rootIndexOfInorder = getIndex(inorder,i,j,rootValue);
		int size = rootIndexOfInorder-i;
		TreeNode root = new TreeNode(rootValue);
		root.left = buildTree(inorder, i, rootIndexOfInorder-1, postorder, m, m+size-1);
		root.right = buildTree(inorder, rootIndexOfInorder+1, j, postorder, m+size,n-1);
		return root;
	}

	
	private int getIndex(int[] inorder, int i, int j, int rootValue) {
		int index = i;
		for(int k=i;k<=j;++k) {
			if(rootValue==inorder[k]) {
				index=k;
				break;
			}
		} 
		return index;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		ConstructBinaryTreeFromInorderAndPostorderTraversal constructBinaryTreeFromInorderAndPostorderTraversal = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
		TreeNode treeNode = constructBinaryTreeFromInorderAndPostorderTraversal.buildTree(new int[]{4, 2,1,5,7,3,6},new int[]{4,2,7,5,6,3,1});
		System.out.println(treeNode);
	}
}	
