package com.xuqin.stack;

class Node<T> {
	T value;
	Node<T> next;
	
	public Node(T value) {
		this.value = value;
		this.next=null;
	}
}

public class Stack<T> {
	
	private Node<T> top;
	private int maxNum;
	private int currentNum;
	
	public Stack(int maxNum) {
		this.top = null;
		this.maxNum=maxNum;
		this.currentNum=0;
	}
	
	public boolean isEmpty() {
		return currentNum==0;
	}
	
	public boolean isFull() {
		return currentNum>=maxNum;
	}
	
	public T push(T value) {
		if(isFull()) {
			System.out.println("Stack is full");
			return null;
		}
		Node<T> node = new Node<T>(value);
		node.next=top;
		top=node;
		currentNum++;
		return value;
	}
	
	public T pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return null;
		}
		T value= top.value;
		top = top.next;
		currentNum--;
		return value;
	} 
	
	public T top() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return null;
		}
		return top.value;
	}
	
	public int size() {
		return currentNum;
	}
}


