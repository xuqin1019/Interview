package com.xuqin.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TreeNode<T extends Comparable<T>> {
	T element;
	TreeNode<T> leftNode;
	TreeNode<T> rightNode;
	public TreeNode(T rootElem) {
		// TODO Auto-generated constructor stub
		element = rootElem;
		leftNode=null;
		rightNode=null;
	}
}

public class SearchTree<T extends Comparable<T>> {
	private TreeNode<T> root;
	
	public SearchTree() {
		root=null;
	} 
	
	public SearchTree(T [] values) {
		if(values==null || values.length==0) {
			root = null;
			return;
		}
		root = new TreeNode<T>(values[0]);
		for(int i=1;i<values.length;++i) {
			T elem = values[i];
			insertNode(elem);
		}
	}
	
	public TreeNode<T> insertNode(T elem) {
		TreeNode<T> newNode = new TreeNode<T>(elem);
		TreeNode<T> tempNode = root;
		TreeNode<T> preNode = tempNode;
		while(tempNode!=null) {
			preNode=tempNode;
			if(newNode.element.compareTo(tempNode.element)>=0) {
				tempNode = tempNode.rightNode;
				if(tempNode==null) {
					preNode.rightNode = newNode;
				}
			} else {
				tempNode = tempNode.leftNode;
				if(tempNode==null) {
					preNode.leftNode = newNode;
				}
			}
		}
		return root;
	}
	
	public TreeNode<T> findNode(T elem) {
		TreeNode<T> tempNode = root;
		while(tempNode!=null) {
			if(tempNode.element.equals(elem)) {
				return tempNode;
			} else if(elem.compareTo(tempNode.element)>0) {
				tempNode=tempNode.rightNode;
			} else {
				tempNode=tempNode.leftNode;
			}
		}
		return null;
	}
	
	
	public Object[] preOrder() {
		return preOrder(root);
	}
	
	private Object[] preOrder(TreeNode<T> treeNode) {
		if(treeNode==null) {
			return null;
		}
		List<Object> results = new ArrayList<Object>();
		results.add(treeNode.element);
		if(treeNode.leftNode!=null) {
			results.addAll(Arrays.asList(preOrder(treeNode.leftNode)));
		}
		if(treeNode.rightNode!=null) {
			results.addAll(Arrays.asList(preOrder(treeNode.rightNode)));
		}
		return results.toArray();
	} 
	
	public Object[] midOrder() {
		return midOrder(root);
	}
	
	private Object[] midOrder(TreeNode<T> treeNode) {
		if(treeNode==null) {
			return null;
		}
		List<Object> results = new ArrayList<Object>();
		if(treeNode.leftNode!=null) {
			results.addAll(Arrays.asList(midOrder(treeNode.leftNode)));
		}
		results.add(treeNode.element);
		if(treeNode.rightNode!=null) {
			results.addAll(Arrays.asList(midOrder(treeNode.rightNode)));
		}
		return results.toArray();
	}

	public Object[] postOrder() {
		return postOrder(root);
	}

	private Object[] postOrder(TreeNode<T> treeNode) {
		if(treeNode==null) {
			return null;
		}
		List<Object> results = new ArrayList<Object>();
		if(treeNode.leftNode!=null) {
			results.addAll(Arrays.asList(postOrder(treeNode.leftNode)));
		}
		if(treeNode.rightNode!=null) {
			results.addAll(Arrays.asList(postOrder(treeNode.rightNode)));
		}
		results.add(treeNode.element);
		return results.toArray();
	}
	
	
	
}
