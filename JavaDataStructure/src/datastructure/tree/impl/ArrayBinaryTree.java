package datastructure.tree.impl;

import datastructure.tree.AbstractTree;
import datastructure.tree.TreeNode;

public class ArrayBinaryTree<T> extends AbstractTree<T> {

	private TreeNode<T> curr;
	
	/**
	 * 使用数组构建二叉树
	 */
	public ArrayBinaryTree(T[] arrs) {
		curr = root;
		for(T i : arrs) {
			insert(i);
		}
	}
	
	public void insert(T value) {
		insert(root,value);
	}

	private TreeNode<T> insert(TreeNode<T> node , T value) {
		if(node == null) {
			node = new TreeNode<T>(value);
		}else {
			if(curr.getLeft() == null) {
				curr.setLeft(insert(curr.getLeft() , value));
			}else {
				curr.setRight(insert(curr.getRight() , value));
			}
		}
		return node;
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

}
