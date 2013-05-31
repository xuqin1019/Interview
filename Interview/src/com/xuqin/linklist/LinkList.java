package com.xuqin.linklist;

import java.util.ArrayList;
import java.util.List;

class Node<T> {
	T value;
	Node<T> next=null;
	
	public Node(T value) {
		this.value = value;
		this.next=null;
	}
}

public class LinkList<T> {
	private Node<T> header=null; 
	private int size;
	
	public LinkList() {
		header = new Node<T>(null);
		size=0;
	}
	
	public boolean isEmpty() {
		return header==null || header.next==null;
	}
	
	public Node<T> find(T value) {
		if(isEmpty()) {
			System.out.println("empty list");
			return null;
		}
		Node<T> node = header;
		while(node.next!=null) {
			if(node.next.value.equals(value)) {
				return node.next;
			} else {
				node=node.next;
			}
		}
		return null;
	}
	
	public Node<T> insert(T value) {
		if(header==null) {
			header = new Node<T>(null);
		}
		Node<T> node = header;
		while(node.next!=null) {
			node=node.next;
		}
		Node<T> newNode = new Node<T>(value);
		node.next=newNode;
		size++;
		return newNode;
	}
	
	public boolean delete(T value) {
		if(isEmpty()) {
			System.out.println("empty list");
			return false;
		}
		Node<T> node = header;
		while(node.next!=null) {
			if(node.next.value.equals(value)) {
				node.next=node.next.next;
				size--;
				return true;
			} else {
				node=node.next;
			}
		}
		return false;
	}
	
	public Object[] getValues() {
		if(isEmpty()) {
			return null;
		}
		List<T> list = new ArrayList<T>();
		//Object [] values = new Object[size];
		Node<T> node = header;
		while(node.next!=null) {
			list.add(node.next.value);
			node = node.next;
		}
		return list.toArray(new Object[size]);
	}
	
	public int getSize() {
		return size;
	}
}
