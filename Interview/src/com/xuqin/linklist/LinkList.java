package com.xuqin.linklist;

import java.util.ArrayList;
import java.util.List;

class Node<T> {
	T value;
	Node<T> next;
	
	public Node(T value) {
		this.value = value;
	}
}

public class LinkList<T> {
	private Node<T> head = null;
	private int size;
	
	public LinkList() {
		head = null;
		size=0;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public Node<T> find(T value) {
		Node<T> node = head;
		while(node != null) {
			if(node.value.equals(value)) {
				return node;
			}
			node = node.next;
		}
		return null;
	}
	
	public Node<T> insert(T value) {
		Node node = new Node(value);
		++size;
		if(head == null) {
			head = node;
			return head;
		}
		node.next = head;
		head = node;
		return head;
	}
	
	public int delete(T value) {
		Node<T> node = head;
		if(node == null) {
			return 0;
		}
		if(node.next==null) {
			if(node.value.equals(value)) {
				head = null;
				--size;
				return 1;
			}
			return 0;
		}
		//at least two items in the list
		int deleteNum = 0;
		Node<T> pre = null;
		while(node != null ) {
			if(node.value.equals(value)) {
				if(pre == null) {
					head = node.next;
					node = node.next;
				} else {
					pre.next = node.next;
					node = pre.next;
				}
				--size;
				deleteNum++;
			} else {
				pre = node;
				node = node.next;
			}
		}
		return deleteNum;
	}
	
	public Object[] getValues() {
		List<T> list = new ArrayList<T>();
		Node<T> node = head;
		while(node != null) {
			list.add(node.value);
			node = node.next;
		}
		return list.toArray(new Object[size]);
	}
	
	public int getSize() {
		return size;
	}
}
