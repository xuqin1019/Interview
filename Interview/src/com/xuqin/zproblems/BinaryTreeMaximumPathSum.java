/**
 * 
 */
package com.xuqin.zproblems;
import java.util.ArrayList;

/**
 * @author xuqin
 *  //Need Review
 * 
 */
public class BinaryTreeMaximumPathSum {      
	public int maxPathSum(TreeNode root) {
		ArrayList<Integer> curMax = new ArrayList<Integer>();
		curMax.add(Integer.MIN_VALUE);
		maxSubPath(root,curMax);
		return curMax.get(0);
    }
	
	private int maxSubPath(TreeNode root, ArrayList<Integer> curMax) {
		if(root==null) {
			return 0;
		}
		int leftMax = Math.max(0, maxSubPath(root.left, curMax));
		int rightMax = Math.max(0, maxSubPath(root.right, curMax));
		curMax.set(0, Math.max(curMax.get(0), root.val+leftMax+rightMax));
		return Math.max(root.val+leftMax, root.val+rightMax);
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	
	public static void main(String[] args) {
		BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();
		
		TreeNode node = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(6);
		TreeNode node6 = new TreeNode(7);
		TreeNode node7 = new TreeNode(8);
		TreeNode node8 = new TreeNode(9);
		
		node.left = node1;
		node.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		node3.left = node7;
		node3.right = node8;
		
		System.out.println(binaryTreeMaximumPathSum.maxPathSum(node));
	}
}
