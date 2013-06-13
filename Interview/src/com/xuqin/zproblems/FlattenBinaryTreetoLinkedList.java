package com.xuqin.zproblems;

import java.util.Stack;

public class FlattenBinaryTreetoLinkedList {
	public void flatten(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) {
        	return;
        }
        
        TreeNode node = root;
        TreeNode preNode = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(node);
        
        while(!stack.empty()) {
        	node = stack.pop();
        	
        	if(node.right!=null) {
        		stack.push(node.right);
        	}
        	
        	if(node.left!=null) {
        		stack.push(node.left);
        	}
        	
        	node.left=null;
        	if(preNode!=null) {
        		preNode.right = node;
        		preNode = node;
        	}
        }
    }
	
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		FlattenBinaryTreetoLinkedList flattenBinaryTreetoLinkedList = new FlattenBinaryTreetoLinkedList();
		
		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(2);
		TreeNode treeNode3 = new TreeNode(3);
		TreeNode treeNode4 = new TreeNode(4);
		TreeNode treeNode5 = new TreeNode(5);
		TreeNode treeNode6 = new TreeNode(6);
		TreeNode treeNode7 = new TreeNode(7);
		TreeNode treeNode8 = new TreeNode(8);
		TreeNode treeNode9 = new TreeNode(9);
		TreeNode treeNode10 = new TreeNode(10);
		TreeNode treeNode11 = new TreeNode(11);
		TreeNode treeNode12 = new TreeNode(12);
		
		
		treeNode1.left = treeNode2;
		treeNode1.right = treeNode5;
		treeNode2.left = treeNode3;
		treeNode2.right = treeNode4;
		treeNode5.right = treeNode6;
		treeNode6.left = treeNode7;
		treeNode6.right = treeNode10;
		treeNode7.left = treeNode8;
		treeNode7.right = treeNode9;
		treeNode10.left = treeNode11;
		treeNode10.right = treeNode12;
		
		flattenBinaryTreetoLinkedList.flatten(treeNode1);
		System.out.println("hello");
	}
}
