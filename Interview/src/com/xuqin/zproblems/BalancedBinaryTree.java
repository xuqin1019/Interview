package com.xuqin.zproblems;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BalancedBinaryTree {
	 public boolean isBalanced(TreeNode root) {
		 if(root==null) {
			 return true;
		 }
		 if(Math.abs(height(root.left)-height(root.right))>1) {
			 return false;
		 }
		 return isBalanced(root.left) && isBalanced(root.right);
	 }
	 
	 public int height(TreeNode root) {
		 if(root==null) {
			 return 0;
		 } 
		 return Math.max(height(root.left), height(root.right))+1;
	 }
	 
	 public int heightBFS(TreeNode root) {
		 if(root==null) {
			 return 0;
		 }
		 Queue<Item> queue = new LinkedBlockingQueue<Item>();
		 TreeNode node = root;
		 queue.add(new Item(node,1));
		 
		 int height=1;
		 
		 while(!queue.isEmpty()) {
			 Item item = queue.poll();
			 TreeNode treeNode = item.node;
			 int level = item.level;
			 
			 if(level>height) {
				 height=level;
			 }
			 
			 if(treeNode.left!=null) {
				 queue.add(new Item(treeNode.left,level+1));
			 }
			 if(treeNode.right!=null) {
				 queue.add(new Item(treeNode.right,level+1));
			 }
		 }
		 return height;
	 }
	 
	 static class Item {
		 TreeNode node;
		 int level;
		 
		public Item(TreeNode node, int level) {
			this.node = node;
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
		 BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
		 TreeNode node1 = new TreeNode(1);
			TreeNode node2 = new TreeNode(-2);
			TreeNode node3 = new TreeNode(-3);
			TreeNode node4 = new TreeNode(1);
			TreeNode node5 = new TreeNode(3);
			TreeNode node6 = new TreeNode(-2);
			TreeNode node7 = new TreeNode(-1);
			node1.left = node2;
			node1.right = node3;
			node2.left = node4;
			node2.right = node5;
			node3.left = node6;
			node4.left = node7;
		 
		 System.out.println(balancedBinaryTree.isBalanced(node1));
		 System.out.println(balancedBinaryTree.heightBFS(node1));
	}
}
