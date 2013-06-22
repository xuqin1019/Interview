/**
 * 
 */
package com.xuqin.zproblems;


/**
 * @author xuqin
 *
 * 
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode nullNode = new ListNode(-1);
		nullNode.next = head;
		
		ListNode preInsertNode = nullNode;
		ListNode p = head;
		ListNode preNode = nullNode;
		while(p!=null) {
			if(p.val>=x) {  //don't need to move 
				preNode = p;
				p=p.next;
			} else { //p.val<x
				
				if(preInsertNode.next!=p) {
				
					preNode.next = p.next;   //delete the front value
				
					p.next = preInsertNode.next;    //insert the value infront
					preInsertNode.next = p;
					preInsertNode = p;
				
					p = preNode.next;
				} else {
					preNode = p;
					preInsertNode = p;
					p = p.next;
				}
			}
		}
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
		PartitionList partitionList = new PartitionList();
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		//node.next.next = new ListNode(2);
		ListNode listNode = partitionList.partition(node, 3);
	}
}
