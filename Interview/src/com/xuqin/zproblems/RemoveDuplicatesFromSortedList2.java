package com.xuqin.zproblems;

public class RemoveDuplicatesFromSortedList2 {
	public ListNode deleteDuplicates(ListNode head) {
		 if(head==null) {
			 return head;
		 }
		 
		 ListNode nullNode = new ListNode(Integer.MIN_VALUE);
		 nullNode.next = head;
		 ListNode insertNode = nullNode;     //used for insert element   
		 
		 ListNode distinctNode = head;
		 ListNode preNode = nullNode;
		 
		 while(distinctNode!=null) {    //distinctNode points to the unique value
			 if(distinctNode.next!=null) {
				 if(preNode.val==distinctNode.val || distinctNode.val == distinctNode.next.val) {
					 preNode = distinctNode;
					 distinctNode = distinctNode.next;
				 } else {
					 insertNode.next = distinctNode;
					 insertNode = distinctNode;
					 
					preNode = distinctNode;
					 distinctNode = distinctNode.next;
				 }
			 } else {   //distinct.next == null
				 if(preNode.val==distinctNode.val) {
					 preNode = distinctNode;
					 distinctNode = distinctNode.next;
				 } else {
					insertNode.next = distinctNode;
					insertNode = distinctNode;
					
					preNode = distinctNode;
					distinctNode = distinctNode.next;
				 }
			 }
		 }
		 insertNode.next = distinctNode;
		 
		 return nullNode.next;
    }
	
	 public static class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
			 val = x;
			 next = null;
		 }
	 }
	 
	 public static void main(String[] args) {
		 ListNode node1 = new ListNode(1);
		 node1.next = new ListNode(1);
		 node1.next.next = new ListNode(1);
		 node1.next.next.next = new ListNode(2);
		 
		RemoveDuplicatesFromSortedList2 removeDuplicatesFromSortedList2 = new RemoveDuplicatesFromSortedList2();
		System.out.println(removeDuplicatesFromSortedList2.deleteDuplicates(node1));
	}
}
