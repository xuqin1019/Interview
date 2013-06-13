package com.xuqin.zproblems;

import java.util.ArrayList;
import java.util.Stack;

public class PathSum2 {
	 public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		 
		 ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		 
		 if(root == null) {
			 return results; 
		 }
		 
		 if(root.left==null && root.right==null && root.val!=sum) {
			 return results;
		 }
		 
		 Stack<Item> stack = new Stack<Item>();
		 stack.add(new Item(root,1,null));
		
		 int remain = sum;
		 Item preItem = new Item(root,0,null);
		 while(!stack.empty()) {
			 Item item = stack.pop();
			 TreeNode treeNode = item.node;
			 int level = item.level;
			 
			 if(level - preItem.level==1) {   
				 remain-=treeNode.val;
				 if(remain==0 && treeNode.left==null && treeNode.right==null) {
					 results.add(getResult(item));
				}
			 } else if(level==preItem.level){
				 remain+=preItem.node.val;
				 remain-=treeNode.val;
				 if(remain==0 && treeNode.left==null && treeNode.right==null) {
					 results.add(getResult(item));
				 }
			 } else if(preItem.level-level>=1) {
				 while(preItem.level>=level) {
					 remain+=preItem.node.val;
					 preItem = preItem.preNode;
				 }
				 remain-=treeNode.val;
				 if(remain==0 && treeNode.left==null && treeNode.right==null) {
					 results.add(getResult(item));
				 }
			 }
			 
			 if(treeNode.right!=null) {
				 stack.add(new Item(treeNode.right,level+1,item));
			 }
			 
			 if(treeNode.left!=null) {
				 stack.add(new Item(treeNode.left,level+1,item));
			 }
			 
			 preItem = item;
		 }
		 
		 return results;
	 }
	 
	 private ArrayList<Integer> getResult(Item item) {
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 result.add(item.node.val);
		 while(item.preNode!=null) {
			 result.add(0,item.preNode.node.val);
			 item = item.preNode;
		 }
		 return result;
	 }
	 
	public static class Item {
		TreeNode node;
		int level;
		Item preNode;
		
		public Item(TreeNode node, int level, Item preNode) {
			this.node = node;
			this.level = level;
			this.preNode = preNode;
		}
	}

	public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	 }
	
	public static void main(String[] args) {
		
		PathSum2 pathSum2 = new PathSum2();
		
//		TreeNode node1 = new TreeNode(5);
//		TreeNode node2 = new TreeNode(4);
//		TreeNode node3 = new TreeNode(8);
//		TreeNode node4 = new TreeNode(11);
//		TreeNode node5 = new TreeNode(13);
//		TreeNode node6 = new TreeNode(4);
//		TreeNode node7 = new TreeNode(7);
//		TreeNode node8 = new TreeNode(2);
//		TreeNode node9 = new TreeNode(5);
//		TreeNode node10 = new TreeNode(1);
//		
//		
//		
//		
//		node1.left = node2;
//		node1.right = node3;
//		node2.left = node4;
//		node3.left = node5;
//		node3.right = node6;
//		node4.left = node7;
//		node4.right = node8;
//		node6.left = node9;
//		node8.right = node10;
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
		
		System.out.println(pathSum2.pathSum(node1, 2));
	}
}
