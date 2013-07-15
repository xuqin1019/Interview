/**
 * 
 */
package com.xuqin.zproblems;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * @author xuqin
 *
 * 
 */



public class PrintAncestorsOfNode {
	
	public boolean printAncestors(TreeNode root , int target) {
		
		if(root==null) {
			return false;
		}
		
		if(root.val == target) {
			return true;
		}
		
		if(printAncestors(root.left, target) || printAncestors(root.right, target)) {
			System.out.println(root.val);
			return true;
		}
		return false;
	}
	
	public boolean printAncestorsWithoutRecursion(TreeNode root , int target) {
		Queue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if(node.left!=null) {
				node.left.pre = node;
				queue.add(node.left);
				if(node.left.val==target) {
					print(node.left);
					return true;
				}
			}
			
			if(node.right!=null) {
				node.right.pre = node;
				queue.add(node.right);
				if(node.right.val==target) {
					print(node.right);
					return true;
				}
			}			
		}
		return false;
	}
	
	/**
	 * @param left
	 */
	private void print(TreeNode node) {
		while(node.pre!=null) {
			System.out.print(node.pre.val + " ");
			node = node.pre;
		}
	}

	public static void main(String[] args) {
		PrintAncestorsOfNode printAncestorsOfNode = new PrintAncestorsOfNode();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		TreeNode node10 = new TreeNode(10);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node4.left = node8;
		node5.right = node9;
		node7.left = node10;
		
	//	printAncestorsOfNode.printAncestors(node1, 9);
	//	printAncestorsOfNode.printAncestorsWithoutRecursion(node1, 9);
		for(int key=1;key<=10;++key) {
			System.out.print(key + " : ");
			printAncestorsOfNode.printAncestorsWithoutRecursion(node1, key);
	        System.out.println();
		}
	}
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode pre;
		TreeNode(int x) { val = x; }
	}
}
