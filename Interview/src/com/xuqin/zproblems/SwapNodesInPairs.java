
/**
 * 
 */
package com.xuqin.zproblems;

/**
 * @author xuqin
 *
 * 
 */
public class SwapNodesInPairs {
	 public ListNode swapPairs(ListNode head) {
	      if(head==null || head.next==null) {
	    	  return head;
	      }  
	      ListNode insertNode = new ListNode(-1);
	      insertNode.next = head;
	      ListNode nullNode = insertNode;
	      
	      ListNode preNode = head;
	      ListNode postNode = head.next;
	      while(preNode!=null && postNode!=null) {
	    	  preNode.next = postNode.next;
	    	  
	    	  postNode.next = preNode;
	    	  insertNode.next = postNode;
	    	  
	    	  insertNode = preNode;
	    	  preNode = preNode.next;
	    	  if(preNode!=null) {
	    		  postNode = preNode.next;
	    	  }
	      }
	      return nullNode.next;
	 }
	 
	  static class ListNode {
	       int val;
	       ListNode next;
	       ListNode(int x) {
	           val = x;
	           next = null;
	       }
	  }
	  
	 public static void main(String[] args) {
		 SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
		 ListNode node1 = new ListNode(1);
		 node1.next = new ListNode(2);
		 node1.next.next = new ListNode(3);
		 node1.next.next.next = new ListNode(4);
		 print(node1);
		 node1 = swapNodesInPairs.swapPairs(node1);
		 print(node1);
	 }

	private static void print(ListNode head) {
		ListNode node = head;
		while(node!=null) {
			System.out.print(node.val+"-->");
			node=node.next;
		}
		System.out.println();
	}
}
