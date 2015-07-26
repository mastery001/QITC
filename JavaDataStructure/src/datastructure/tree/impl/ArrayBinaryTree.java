package datastructure.tree.impl;

import datastructure.tree.AbstractTree;
import datastructure.tree.TreeNode;

public class ArrayBinaryTree<T> extends AbstractTree<T> {

	/**
	 * 使用数组构建二叉树
	 */
	public ArrayBinaryTree(T[] arrs) {
		for (T i : arrs) {
			insert(i);
		}
	}

	@Override
	public TreeNode<T> insertLeftNode(TreeNode<T> curr, T data) {
		throw new UnsupportedOperationException(
				"This method has not been implemented");
	}

	@Override
	public TreeNode<T> insertRightNode(TreeNode<T> curr, T data) {
		throw new UnsupportedOperationException(
				"This method has not been implemented");
	}

	@Override
	public TreeNode<T> deleteLeftNode(TreeNode<T> curr) {
		throw new UnsupportedOperationException(
				"This method has not been implemented");
	}

	@Override
	public TreeNode<T> deleteRightNode(TreeNode<T> curr) {
		throw new UnsupportedOperationException(
				"This method has not been implemented");
	}

}
