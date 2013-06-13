/**
 * 
 */
package com.xuqin.zproblems;


/**
 * @author xuqin
 *
 * 
 */
public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		 if(p==null && q==null) {
			 return true;
		 } else if(p!=null && q!=null) {
			 return (p.val==q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
