/**
 * 
 */
package com.xuqin.zproblems;

import java.util.Stack;
/**
 * @author xuqin
 *
 * 
 */



public class SumRootToLeafNumbers {
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int sumNumbers(TreeNode root) {

	    return helper(root,0);

	}

	public int helper(TreeNode root, int res){

	    if(root == null)
	        return 0;

	     res = res*10 + root.val;

	     int sum=0;

	     sum+=helper(root.left, res);
	     sum+=helper(root.right, res);

	     if(sum==0) {   //the node is the leaf node
	    	// System.out.println("node : " + root.val);
	    	 sum = res; 
	     }

	     return sum;

	}
	
	public int sum(TreeNode root) {
		if(root == null) {
			return 0;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
	    int sum = 0;
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			
			if(node.left==null && node.right==null) { //leaf node
				sum+=node.val;
			}
			
			if(node.right!=null) {
				node.right.val += node.val*10;
				stack.push(node.right);
			}
			
			if(node.left!=null) {
				node.left.val += node.val*10;
				stack.push(node.left);
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		SumRootToLeafNumbers sumRootToLeafNumbers = new SumRootToLeafNumbers();
		
		TreeNode node = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(6);
		TreeNode node6 = new TreeNode(7);
		TreeNode node7 = new TreeNode(8);
		TreeNode node8 = new TreeNode(9);
		
		node.left = node1;
		node.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		node3.left = node7;
		node3.right = node8;
		
		System.out.println(sumRootToLeafNumbers.sumNumbers(node));
		System.out.println(sumRootToLeafNumbers.sum(node));
	}
}
