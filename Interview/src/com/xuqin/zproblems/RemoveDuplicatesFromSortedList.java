package com.xuqin.zproblems;

public class RemoveDuplicatesFromSortedList {
	 public ListNode deleteDuplicates(ListNode head) {
		 
		 if(head==null) {
			 return head;
		 }
		 
		 ListNode preNode = head;
		 ListNode node = preNode.next;
		 int value = preNode.val;
		 
		 while(node!=null) {
			 if(node.val==value) {
				 node = node.next;
			 } else {
				 preNode.next = node;
				 preNode = node;
				 node = node.next;
				 value = preNode.val;
			 }
		 }
		 preNode.next = node;
		 
		 return head;
	 }
	 
	 public static class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
			 val = x;
			 next = null;
		 }
	 }
}
