/**
 * 
 */
package com.xuqin.zproblems;
/**
 * @author xuqin
 *
 * 
 */
public class SymmetricTree {
	 public boolean isSymmetric(TreeNode root) {
		 if(root==null || (root.left==null&&root.right==null)) {
			 return true;
		 }
		 slip(root.left);
		 return isTheSame(root.left, root.right);
	 }
	 
	private void slip(TreeNode root) {
		if(root==null) {
			return;
		}
		swap(root);
		slip(root.left);
		slip(root.right);
	}
	
	private void swap(TreeNode root) {
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
	}


	public static boolean isTheSame(TreeNode node1,TreeNode node2) {
		 if(node1==null && node2==null) {
			 return true;
		 } else if(node1!=null && node2!=null) {
			 return (node1.val==node2.val) && isTheSame(node1.left, node2.left) && isTheSame(node1.right, node2.right);
		 } else {
			 return false;
		 }
	 }
	 
	 public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	 }
	 
	 
}
