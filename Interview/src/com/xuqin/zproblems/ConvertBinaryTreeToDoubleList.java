/**
 * 
 */
package com.xuqin.zproblems;

/**
 * @author xuqin
 *
 * 
 */
public class ConvertBinaryTreeToDoubleList {
	
	public void inorder(TreeNode root) {
		if(root!=null) {
			inorder(root.left);
			System.out.print(root.val+"\t");
			inorder(root.right);
		}
	}
	
	public TreeNode BTToDLL(TreeNode root) {
		fixPrevPtr(root,null);
		return fixNextPtr(root);
	}
	
	private void fixPrevPtr(TreeNode root,TreeNode pre) {
		if(root!=null) {
			fixPrevPtr(root.left,pre);
			root.left = pre;
			pre=root;
			fixPrevPtr(root.right,pre);
		}
	}
	
	private TreeNode fixNextPtr(TreeNode root) {
		TreeNode prev = null;
		while(root!=null && root.right!=null) {
			root=root.right;
		}
		
		while(root!=null && root.left!=null) {
			prev = root;
			root = root.left;
			root.right = prev;
		}
		return root;
	}
	
	public void printList(TreeNode root) {
		while(root!=null) {
			System.out.print(root.val+"\t");
			root = root.right;
		}
	}
	
	public TreeNode bintree2listUtil(TreeNode root) {
		// Base case
		if(root==null) {
			return root;
		}
		
		// Convert the left subtree and link to root
		if(root.left!=null) {
			// Convert the left subtree
			TreeNode left = bintree2listUtil(root.left);
			
			// Find inorder predecessor. After this loop, left
	        // will point to the inorder predecessor
			for(;left.right!=null ; left= left.right);
			
			// Make root as next of the predecessor
			left.right = root;
			
			// Make predecssor as previous of root
			root.left = left;
		}
		
		 // Convert the right subtree and link to root
		if(root.right!=null) {
			 // Convert the right subtree
			TreeNode right = bintree2listUtil(root.right);
			
			// Find inorder successor. After this loop, right
	        // will point to the inorder successor
			for(;right.left!=null;right=right.left);
			
			// Make root as previous of successor
			right.left = root;
			
			// Make successor as next of root
			root.right = right;
		}
		
		return root;
	}
	
	public TreeNode bintree2list(TreeNode root) {
		if(root==null) {
			return root;
		}
		
		root = bintree2listUtil(root);
		
		while(root.left!=null) {
			root = root.left;
		}
		
		return root;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(10);
		TreeNode node2 = new TreeNode(12);
		TreeNode node3 = new TreeNode(15);
		TreeNode node4 = new TreeNode(25);
		TreeNode node5 = new TreeNode(30);
		TreeNode node6 = new TreeNode(36);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		
		ConvertBinaryTreeToDoubleList convertBinaryTreeToDoubleList = new ConvertBinaryTreeToDoubleList();
		convertBinaryTreeToDoubleList.inorder(node1);
		System.out.println();
	//	convertBinaryTreeToDoubleList.printList(convertBinaryTreeToDoubleList.BTToDLL(node1));
		convertBinaryTreeToDoubleList.printList(convertBinaryTreeToDoubleList.bintree2list(node1));
	}
}
