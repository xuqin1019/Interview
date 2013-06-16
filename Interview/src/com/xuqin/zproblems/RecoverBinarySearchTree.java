/**
 * 
 */
package com.xuqin.zproblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
/**
 * @author xuqin
 *
 * 
 */
public class RecoverBinarySearchTree {
	
	 private ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
	 
	 public void recoverTree(TreeNode root) {
		 ArrayList<Integer> results = inorderTraversal(root);
		 
		 Collections.sort(results);
		 for(int i=0;i<results.size();++i) {
			 nodes.get(i).val = results.get(i);
		 }
		 
		 
	 }
	 
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
						nodes.add(currentNode);
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
	 
	public static void main(String[] args) {
		RecoverBinarySearchTree recoverBinarySearchTree = new RecoverBinarySearchTree();
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		recoverBinarySearchTree.recoverTree(node);
		System.out.println(recoverBinarySearchTree.inorderTraversal(node));
	}
}
