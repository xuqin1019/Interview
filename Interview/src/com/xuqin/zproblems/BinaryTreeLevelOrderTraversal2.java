/**
 * 
 */
package com.xuqin.zproblems;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author xuqin
 *
 * 
 */
public class BinaryTreeLevelOrderTraversal2 {
	 public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		 
		 ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		 
		 if(root==null) {
			return results;
		 }
		 
		 Queue<Item> queue = new LinkedBlockingQueue<Item>();
		 TreeNode node = root;
		 queue.add(new Item(node, 1));
		 ArrayList<Integer> levelNode = new ArrayList<Integer>();
		 int preLevel = 1;
		 
		 while(!queue.isEmpty()) {
			 Item item = queue.poll();
			 TreeNode treeNode = item.treeNode;
			 int level = item.level;
			 
			 if(level>preLevel) {
				 results.add(0,(ArrayList<Integer>) levelNode.clone());
				 levelNode.clear();
				 levelNode.add(treeNode.val);
				 preLevel = level;
			 } else {
				 levelNode.add(treeNode.val);
			 }
			 
			 if(treeNode.left!=null) {
				 queue.add(new Item(treeNode.left, level+1));
			 }
			 
			 if(treeNode.right!=null) {
				 queue.add(new Item(treeNode.right, level+1));
			 }
		 }
		 if(!levelNode.isEmpty()) {
			 results.add(0,levelNode);
		 }
		 
		 return results;
	 }
	 
	 
	 static class Item {
		 TreeNode treeNode;
		 int level;
		public Item(TreeNode treeNode, int level) {
			this.treeNode = treeNode;
			this.level = level;
		}
		 
	 }
	 
	 public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	 }
	 
	 public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal2 binaryTreeLevelOrderTraversal2 = new BinaryTreeLevelOrderTraversal2();
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;
		ArrayList<ArrayList<Integer>> node = binaryTreeLevelOrderTraversal2.levelOrderBottom(node1);
		System.out.println(node);
	}
}
