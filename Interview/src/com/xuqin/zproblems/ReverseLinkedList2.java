/**
 * 
 */
package com.xuqin.zproblems;

/**
 * @author xuqin
 *
 * 
 */
public class ReverseLinkedList2 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(m==n) {
			return head;
		}
		ListNode node = head;
		ListNode pre = null;    //pre points to the (m-1)th node ,the node before the mth node
		for(int i=0;i<m-1;++i) {
			if(i==m-2) {
				pre = node;
			}
			node=node.next;
		}
		
		ListNode p = node;
		//p point to the mth node
		ListNode middleNode = p.next;   //cannot be null
		ListNode postNode = p.next.next; //maybe null
		
		int step = 1;
		while(postNode!=null && step++<=n-m-1) {
			middleNode.next = p;
			
			p = middleNode;            //move forward
			middleNode = postNode;
			postNode = postNode.next;
		}
		
		if(pre!=null) {
			pre.next = middleNode;
		} 
		middleNode.next=p;
		node.next = postNode;
		
		if(node!=head) {
			return head;
		} else {
			return middleNode;
		}
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
		ReverseLinkedList2 reverseLinkedList2 = new ReverseLinkedList2();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		reverseLinkedList2.reverseBetween(head, 2, 4);
	}
}
