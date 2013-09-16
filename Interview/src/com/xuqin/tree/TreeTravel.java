/**
 * 
 */
package com.xuqin.tree;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class TreeTravel {
	//--------------------levelOrder---------------------
	public static void levelOrder(TreeNode treeNode) {
		if(treeNode==null) {
			return;
		}
		Queue<TreeNode> queue= new LinkedBlockingQueue<TreeNode>();
		queue.add(treeNode);
		
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.print(node.value + " ");
			if(node.left!=null) {
				queue.add(node.left);
			}
			if(node.right!=null) {
				queue.add(node.right);
			}
		}
	}
	
	//--------------------preOrder-----------------------
	public static void preOrderRecursion(TreeNode treeNode) {
		if(treeNode==null) {
			return;
		}
		System.out.print(treeNode.value + " ");
		preOrderRecursion(treeNode.left);
		preOrderRecursion(treeNode.right);
	}
	
	public static void preOrderWithoutRecursion(TreeNode treeNode) {
		if(treeNode==null) {
			return;
		}
		Stack<TreeNode> stacks = new Stack<TreeNode>();
		TreeNode node = treeNode;
		while(node!=null || !stacks.isEmpty()) {
			if(node!=null) {
				stacks.push(node);
				System.out.print(node.value + " ");
				node = node.left;
			} else {
				node = stacks.pop();
				node = node.right;
			}
		}
	}
	
	//-------------------inOrder---------------------------
	public static void inOrderRecursion(TreeNode treeNode) {
		if(treeNode==null) {
			return;
		}
		inOrderRecursion(treeNode.left);
		System.out.print(treeNode.value + " ");
		inOrderRecursion(treeNode.right);
	}
	
	public static void inOrderWithoutRecursion(TreeNode treeNode) {
		if(treeNode==null) {
			return;
		}
		Stack<TreeNode> stacks = new Stack<TreeNode>();
		TreeNode node = treeNode;
		while(node!=null || !stacks.isEmpty()) {
			if(node!=null) {
				stacks.push(node);
				node = node.left;
			} else {   //node==null && stacks not empty
				node = stacks.pop();
				System.out.print(node.value + " ");
				node = node.right;
			}
		}
	}
	
	
	//-------------------postOrder-------------------------
	public static void postOrderRecursion(TreeNode treeNode) {
		if(treeNode==null) {
			return;
		}
		postOrderRecursion(treeNode.left);
		postOrderRecursion(treeNode.right);
		System.out.print(treeNode.value + " ");
	}
	
	public static void postOrderWithoutRecursion(TreeNode treeNode) {
	}
	
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node21 = new TreeNode(2);
		TreeNode node22 = new TreeNode(3);
		TreeNode node31 = new TreeNode(4);
		TreeNode node32 = new TreeNode(5);
		TreeNode node33 = new TreeNode(6);
		TreeNode node34 = new TreeNode(7);
		
		node1.left = node21;
		node1.right = node22;
		node21.left = node31;
		node21.right = node32;
		node22.left = node33;
		node22.right = node34;
		
		System.out.print("LevelOrder : ");
		levelOrder(node1);
		System.out.println();
		System.out.println();
		
		System.out.print("PreOrderRecursion : ");
		preOrderRecursion(node1);
		System.out.println();
		System.out.print("PreOrderWithoutRecursion : ");
		preOrderWithoutRecursion(node1);
		System.out.println();
		System.out.println();
		
		
		System.out.print("InOrderRecursion : ");
		inOrderRecursion(node1);
		System.out.println();
		System.out.print("InOrderWithoutRecursion : ");
		inOrderWithoutRecursion(node1);
		System.out.println();
		System.out.println();
		
		System.out.print("PostOrderRecursion : ");
		postOrderRecursion(node1);
		System.out.println();
		System.out.print("PostOrderWithoutRecursion : ");
		postOrderWithoutRecursion(node1);
		System.out.println();

	}
	
	
	static class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;
		public TreeNode(int value) {
			this.value = value;
		}
	}
}

