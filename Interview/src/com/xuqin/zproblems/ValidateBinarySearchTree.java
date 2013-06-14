/**
 * 
 */
package com.xuqin.zproblems;

/**
 * @author xuqin
 *
 *LeetCode    Need Review!!! 
 */
public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		if(root == null) {
			return true;
		}
		if(root.left==null && root.right==null) {
			return true;
		}
		
		return isSubTreeLessThan(root.left, root.val) && isSubTreeGreaterThan(root.right, root.val) && isValidBST(root.left) && isValidBST(root.right);
    }
	
	boolean isSubTreeLessThan(TreeNode p , int val) {
		if(p==null) {
			return true;
		}
		return p.val < val && isSubTreeLessThan(p.left, val) && isSubTreeLessThan(p.right, val);
	}
	
	boolean isSubTreeGreaterThan(TreeNode p, int val) {
		if(p==null) {
			return true;
		}
		return p.val > val && isSubTreeGreaterThan(p.left, val) && isSubTreeGreaterThan(p.right, val);
	}
	
	
	public boolean isValidBST2(TreeNode root) {         // a better way
		return isBSTHelper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	private boolean isBSTHelper(TreeNode node, int minValue, int maxValue) {     //check the node value
		if(node==null) {
			return true;
		}
		if(minValue < node.val && node.val < maxValue) {
			return isBSTHelper(node.left, minValue, node.val) && isBSTHelper(node.right, node.val, maxValue);
		} else {
			return false;
		}
	}

	public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
}
