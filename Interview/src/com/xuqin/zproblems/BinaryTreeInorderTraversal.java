package com.xuqin.zproblems;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 */

/**
 * @author xuqin
 *
 * 
 */
public class BinaryTreeInorderTraversal {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		
		ArrayList<Integer> results = new ArrayList<Integer>();
		
		if(root==null) {
			return results;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		stack.add(node);
		//results.add(node.val);
		while(!stack.isEmpty()) {
			TreeNode treeNode = stack.pop();
			results.add(treeNode.val);
			if(treeNode.left!=null) {
				stack.push(treeNode.left);
			}
			if(treeNode.right!=null) {
				stack.push(treeNode.right);
			}
		}
		return results;
    }	
	
	public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	 }
}
