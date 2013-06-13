package com.xuqin.zproblems;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) {
			return false;
		}
		return hasPath(root,sum,root);
    }
	
	private boolean hasPath(TreeNode root, int sum,TreeNode parentNode) {
		 
		if(root==null) {   
			return sum==0 && parentNode.left==null && parentNode.right==null;   //leafNode and sum=0;
		}
	    return hasPath(root.left, sum-root.val,root) || hasPath(root.right, sum-root.val,root);
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		PathSum pathSum = new PathSum();
		
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(8);
		TreeNode node4 = new TreeNode(11);
		TreeNode node5 = new TreeNode(13);
		TreeNode node6 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(2);
		TreeNode node9 = new TreeNode(1);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.left = node5;
		node3.right = node6;
		node4.left = node7;
		node4.right = node8;
		node6.right = node9;
		
		System.out.println(pathSum.hasPathSum(node1, 22));
	}
}
