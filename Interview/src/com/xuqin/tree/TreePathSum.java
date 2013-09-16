/**
 * 
 */
package com.xuqin.tree;


/**
 * @author xuqin
 *
 * 
 */
public class TreePathSum {
	
	public void pathSum(TreeNode root , int sum , int path[] , int index) {
		path[index++] = root.value;
		sum-= root.value;
		
		
		if(sum==0) {
			printPath(path,index);
		}
//		if(sum<0) {
//			return;
//		}
		
		if(root.left!=null) {
			pathSum(root.left, sum, path,index);
		}
		if(root.right!=null) {
			pathSum(root.right, sum, path, index);
		} 
	
		index--;
		sum+=root.value;
		
	}
	
	/**
	 * @param path
	 * @param index
	 */
	private void printPath(int[] path, int index) {
		for(int i=0;i<index;++i) {
			System.out.print(path[i] + " ");
		}
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreePathSum treePathSum = new TreePathSum();
		int [] path = new int[1024];
		
		TreeNode node1 = new TreeNode(10);
		TreeNode node21 = new TreeNode(-12);
		TreeNode node22 = new TreeNode(12);
		TreeNode node31 = new TreeNode(4);
		TreeNode node32 = new TreeNode(7);
		TreeNode node41 = new TreeNode(20);
 		
		node1.left = node21;
		node1.right = node22;
		node21.left = node31;
		node22.right = node32;
		node31.left = node41;
		
		treePathSum.pathSum(node1, 22, path, 0);
	}
	
	static class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;
		public TreeNode(int value) {
			this.value = value;
		}
	}
}


