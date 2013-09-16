/**
 * 
 */
package com.xuqin.tree;


/**
 * @author xuqin
 *
 * 
 */
public class CheckSameLevel {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 	TreeNode root = new TreeNode(12);
		    root.left = new TreeNode(5);
		    root.left.left = new TreeNode(3);
		    root.left.right = new TreeNode(9);
		    root.left.left.left = new TreeNode(1);
		    root.left.right.left = new TreeNode(1);
		    System.out.println(CheckSameLevel.isSameLevel(root));
	}
	
	private static int height = 0;
	
	public static boolean isSameLevel(TreeNode node) {
		if(node==null) {
			return false;
		}
		return checkSameLevel(node,1);
	}
	
	private static boolean checkSameLevel(TreeNode node, int level) {
		if(node.left==null && node.right==null) {   //leaf node
			if(height==0) {
				height=level;
			}
			return height == level;
		}
		
		boolean sameLevel = false; 
		if(node.left!=null) {
			sameLevel = checkSameLevel(node.left, level+1);
		}
		if(node.right!=null) {
			sameLevel = sameLevel && checkSameLevel(node.right, level+1);
		}
		return sameLevel;
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
