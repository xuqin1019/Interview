package com.xuqin.zproblems;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class MinimumDepthOfBinaryTree {
	public int minDepth(TreeNode root) {
		if(root==null) {
			return 0;
		}
		Queue<Item> queue = new LinkedBlockingQueue<Item>();
		TreeNode node = root;
		queue.add(new Item(node, 1));
		while(!queue.isEmpty()) {
			Item item = queue.poll();
			TreeNode treeNode = item.treeNode;
			int level = item.level;
			
			if(treeNode.left==null && treeNode.right==null) {
				return level;
			}
			
			if(treeNode.left!=null) {
				queue.add(new Item(treeNode.left, level+1));
			}
			if(treeNode.right!=null) {
				queue.add(new Item(treeNode.right, level+1));
			}
		}
		
		return 0;    //this can not be happen 
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
		MinimumDepthOfBinaryTree minimumDepthOfBinaryTree = new MinimumDepthOfBinaryTree();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(-2);
		TreeNode node3 = new TreeNode(-3);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(3);
	//	TreeNode node6 = new TreeNode(-2);
		TreeNode node7 = new TreeNode(-1);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
	//	node3.left = node6;
		node4.left = node7;
		System.out.println(minimumDepthOfBinaryTree.minDepth(node1));
	}
}
