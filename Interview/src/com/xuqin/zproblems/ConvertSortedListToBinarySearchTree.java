package com.xuqin.zproblems;

import java.util.ArrayList;
import java.util.List;

import com.xuqin.zproblems.ConvertSortedArrayToBinarySearchTree.TreeNode;


public class ConvertSortedListToBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
//		int length = getLength(head);
//		return sortedListToBST(head,0,length-1);
		
		int [] num = listToArray(head);
		
		 if(num==null || num.length==0) {
			 return null;
		 }
		 return sortedArrayToBST(num,0,num.length-1);
    }
	
	private TreeNode sortedArrayToBST(int[] num, int start, int end) {
		if(start>end) {
			return null;
		}
		int middle = start+(end-start)/2;
		TreeNode root = new TreeNode(num[middle]);
		root.left = sortedArrayToBST(num, start, middle-1);
		root.right = sortedArrayToBST(num, middle+1, end);
		return root;
	}
	
	private int[] listToArray(ListNode head) {
		List<Integer> list = new ArrayList<Integer>();
		ListNode node = head;
		while(node!=null) {
			list.add(node.val);
			node = node.next;
		}
		
		int [] num = new int[list.size()];
		for(int i=0;i<num.length;++i) {
			num[i] = list.get(i);
		}
		
		return num;
	}

	private TreeNode sortedListToBST(ListNode list, int start, int end) {
		if(start>end) {
			return null;
		}
		int mid = start + (end-start)/2;
		
		TreeNode leftChild = sortedListToBST(list, start, mid-1);
		
		
		int i=0;
		while(i++<mid) {
			list.next = list;
		}
		
		TreeNode parent = new TreeNode(list.val);
		
		parent.left = leftChild;
		list = list.next;
		parent.right = sortedListToBST(list, mid+1, end);
		return parent;
	}

	private int getLength(ListNode head) {
		int length = 0;
		while(head!=null) {
			length++;
			head=head.next;
		}
		return length;
	}

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; next = null; }
	}
		 
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		ConvertSortedListToBinarySearchTree convertSortedListToBinarySearchTree = new ConvertSortedListToBinarySearchTree();
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		
		TreeNode treeNode = convertSortedListToBinarySearchTree.sortedListToBST(head);
		//treeNode.left=null;
		System.out.println("1");
	}
}
