package com.xuqin.zproblems;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;


public class PopulatingNextRightPointers {
	 public void connect(TreeLinkNode root) {
		 if(root==null) {
			 return;
		 }
		 if(root.left==null && root.right==null) {
			 root.next=null;
		 }
		 
		 Queue<Item> queue = new LinkedBlockingQueue<Item>();
		 int prelevel = 0;
		 TreeLinkNode preNode = root;
		 TreeLinkNode node = root;
		 
		 queue.add(new Item(node, prelevel+1));
		 while(!queue.isEmpty()) {
			 Item item = queue.poll();
			 TreeLinkNode treeLinkNode = item.treeLinkNode;
			 int currlevel = item.level;
			 
			 if(currlevel>prelevel) {   //the first node on the next level
				 preNode.next=null;
				 prelevel=currlevel;
			 } else {
				 preNode.next=treeLinkNode;
			 }
			 preNode=treeLinkNode;
			 
			 if(treeLinkNode.left!=null) {
				 queue.add(new Item(treeLinkNode.left, currlevel+1));
			 }
			 if(treeLinkNode.right!=null) {
				 queue.add(new Item(treeLinkNode.right, currlevel+1));
			 }
		 }
	 }
	 
	 public static class TreeLinkNode {
		 int val;
		 TreeLinkNode left, right, next;
		 TreeLinkNode(int x) { val = x; }
	 }
	 
	 public static class Item {
		 TreeLinkNode treeLinkNode;
		 int level;
		 
		 public Item(TreeLinkNode treeLinkNode, int level) {
			this.treeLinkNode = treeLinkNode;
			this.level = level;
		 }
	 }
	 
	public static void main(String[] args) {
		TreeLinkNode node1 = new TreeLinkNode(1);
		TreeLinkNode node2 = new TreeLinkNode(2);
		TreeLinkNode node3 = new TreeLinkNode(3);
		TreeLinkNode node4 = new TreeLinkNode(4);
		TreeLinkNode node5 = new TreeLinkNode(5);
		TreeLinkNode node6 = new TreeLinkNode(6);
		TreeLinkNode node7 = new TreeLinkNode(7);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		
		PopulatingNextRightPointers pnrp = new PopulatingNextRightPointers();
		pnrp.connect(node1);
		System.out.println(1);
	}
}
