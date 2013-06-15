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
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode currentNode = root;
		boolean over = false;
		while(!over) {
			if(currentNode!=null) {
				stack.push(currentNode);
				currentNode=currentNode.left;
			} else {
				if(!stack.isEmpty()) {
					currentNode = stack.pop();
					results.add(currentNode.val);
					currentNode = currentNode.right;
				} else {
					over = true;
				}
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
