package com.xuqin.zproblems;

import java.util.ArrayList;
import java.util.List;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        List<Integer> inorderList = getList(inorder);
        List<Integer> postOrderList = getList(postorder);
        return buildTree(inorderList, postOrderList);
    }
	
	private TreeNode buildTree(List<Integer> inorderList,List<Integer> postOrderList) {
		int rootValue = postOrderList.get(postOrderList.size()-1);
		TreeNode root = new TreeNode(rootValue);
		int rootIndexOfInorder = inorderList.indexOf(rootValue);
		
		return root;
		
	}

	private List<Integer> getList(int[] array) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i : array) {
			list.add(i);
		}
		return list;
	}

	
	private int getIndex(int[] inorder, int rootValue) {
		int i=0;
		for(i=0;i<inorder.length;++i) {
			if(inorder[i]==rootValue) {
				return i;
			}
		}
		return i;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
