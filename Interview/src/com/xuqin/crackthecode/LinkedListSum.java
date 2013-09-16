/**
 * 
 */
package com.xuqin.crackthecode;

/**
 * @author xuqin
 *
 * 
 */
public class LinkedListSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(8);
		node1.next = new ListNode(0);
		node1.next.next = new ListNode(8);
		node1.next.next.next = new ListNode(0);
		node1.next.next.next.next = new ListNode(8);
		
		ListNode node2 = new ListNode(3);
		node2.next = new ListNode(1);
		node2.next.next = new ListNode(6);
		
		ResultListNode resultListNode = calSum(0, node1, node2);
		ResultListNode node = resultListNode;
		while(node!=null) {
			System.out.print(node.value + " ");
			node=node.next;
		}
	}
	
	public static ResultListNode calSum(int change,ListNode node1 , ListNode node2) {
		if(node1==null && node2==null) {
			return null;
		}
		
		ResultListNode result = new ResultListNode();
		
		int nextChange = (((node1!=null)? node1.value : 0) + ((node2!=null) ? node2.value : 0) + change) /10;
		int value =  (((node1!=null)? node1.value : 0) + ((node2!=null) ? node2.value : 0) + change) %10;
		result.change = change;
		result.value = value;
		
		
		result.next = calSum(nextChange, node1==null ? null : node1.next, node2 == null ? null : node2.next);
		
		return result;
	}
	
	static class ListNode {
		public ListNode(int value) {
			this.value = value;
		}
		
		int value;
		ListNode next;
	}
	
	static class ResultListNode {
		int value;
		int change;
		
		ResultListNode next;
	}
}
