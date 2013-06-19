package com.xuqin.zproblems;

import java.util.ArrayList;

public class UniqueBinarySearchTrees2 {
	public ArrayList<TreeNode> generateTrees(int n) {
		if(n==0) {
			ArrayList<TreeNode> results = new ArrayList<TreeNode>();
			results.add(null);
			return results;
		}
        return generateTree(1, n);
    }
	
	
	ArrayList<TreeNode> generateTree(int m,int n) {
		ArrayList<TreeNode> results = new ArrayList<TreeNode>();
		
		if(m==n) {
			results.add(new TreeNode(m));
			return results;
		} else if(m>n) {
			return results;
		} else if(n-m==1) {
			TreeNode head1 = new TreeNode(m);
			head1.right = new TreeNode(n);
			results.add(head1);
			
			TreeNode head2 = new TreeNode(n);
			head2.left = new TreeNode(m);
			results.add(head2);
			
			return results; 
		}
		
		for(int i=m;i<=n;++i) {
			ArrayList<TreeNode> leftTreeList = generateTree(m,i-1);
			ArrayList<TreeNode> rightTreeList = generateTree(i+1, n);
			if(leftTreeList.size()!=0 && rightTreeList.size()!=0) {
				for(TreeNode leftNode : leftTreeList) {
					for(TreeNode rightNode : rightTreeList) {
						TreeNode head = new TreeNode(i);
						head.left = leftNode;
						head.right = rightNode;
						results.add(head);
					}
				}
			} else if(leftTreeList.size()!=0) {
				for(TreeNode leftNode : leftTreeList) {
					TreeNode head = new TreeNode(i);
					head.left = leftNode;
					results.add(head);
				} 
			} else if(rightTreeList.size()!=0) {
				for(TreeNode rightNode : rightTreeList) {
					TreeNode head = new TreeNode(i);
					head.right = rightNode;
					results.add(head);
				}
			}
		} 
		return results;
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; left = null; right = null; }
	}
}
