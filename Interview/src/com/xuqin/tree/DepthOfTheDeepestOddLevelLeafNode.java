/**
 * 
 */
package com.xuqin.tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * @author xuqin
 *
 * 
 */
public class DepthOfTheDeepestOddLevelLeafNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
	    root.left = new TreeNode(2);
	    root.right = new TreeNode(3);
	    root.left.left = new TreeNode(4);
	    root.right.left = new TreeNode(5);
	    root.right.right = new TreeNode(6);
	    root.right.left.right = new TreeNode(7);
	    root.right.right.right = new TreeNode(8);
	    root.right.left.right.left = new TreeNode(9);
	    root.right.right.right.right = new TreeNode(10);
	    root.right.right.right.right.left = new TreeNode(11);
	    System.out.println(depthOfDeepestOddLevel(root));
	}
	
	public static int depthOfDeepestOddLevel(TreeNode treeNode) {
		if(treeNode==null) {
			return 0;
		}
		int level = 1;
		int maxOddLevel = 1;
		Queue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();
		queue.add(treeNode);
		treeNode.level=1;
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			level = node.level;
			if(node.left==null && node.right==null && level%2==1) {
				maxOddLevel = Math.max(maxOddLevel, level);
			}
			if(node.left!=null) {
				node.left.level = level+1;
				queue.add(node.left);
			}
			if(node.right!=null) {
				node.right.level = level+1;
				queue.add(node.right);
			}
		}
		return maxOddLevel;
	}
	
	static class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;
		int level;
		public TreeNode(int value) {
			this.value = value;
		}
		
		public TreeNode(int value,int level) {
			this.value = value;
			this.level = level;
		}
	}

}
