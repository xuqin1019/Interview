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
public class BinaryTreeZigzagLevelOrderTraversal {
	 public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
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
				 results.add((ArrayList<Integer>) levelNode.clone());
				 levelNode.clear();
				 preLevel = level;
			 } 
			 
			 if(level%2==1) {
				 levelNode.add(treeNode.val);
			 } else {
				 levelNode.add(0,treeNode.val);
			 }
			 
			 if(treeNode.left!=null) {
				 queue.add(new Item(treeNode.left, level+1));
			 }
			 
			 if(treeNode.right!=null) {
				 queue.add(new Item(treeNode.right, level+1));
			 }
		 }
		 if(!levelNode.isEmpty()) {
			 results.add(levelNode);
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
	 
	 public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	 }
}
