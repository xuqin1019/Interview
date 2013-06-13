/**
 * 
 */
package com.xuqin.zproblems;

/**
 * @author xuqin
 *
 * 
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder==null || preorder.length==0) {
			return null;
		}
		return buildTree(preorder, 0,preorder.length-1,inorder,0,inorder.length-1);
    }
	
	private TreeNode buildTree(int[] preorder, int i, int j, int[] inorder,int m, int n) {
		if(i>j) {
			return null;
		}
		int rootValue = preorder[i];
		int rootIndexOfInorder = getIndex(inorder,m,n,rootValue);
		int size = rootIndexOfInorder-m;
		TreeNode root = new TreeNode(rootValue);
		root.left = buildTree(preorder,i+1, i+size,inorder, m, rootIndexOfInorder-1);
		root.right = buildTree(preorder, i+size+1,j, inorder, rootIndexOfInorder+1,n);
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
}
