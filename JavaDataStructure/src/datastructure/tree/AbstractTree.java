package datastructure.tree;

import datastructure.tree.traverse.PreOrderTraverse;
import datastructure.util.Util;

public abstract class AbstractTree<T> implements BinaryTree<T> {

	protected int deep;
	
	protected int size;
	
	protected TreeNode<T> root;
	
	@Override
	public int deep() {
		return deep;
	}

	@Override
	public boolean isNullTree() {
		return deep() == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public TreeNode<T> root() {
		return root;
	}

	/**
	 * 默认实现方法，从root处递归插入
	 * @param value
	 */
	public void insert(T value) {
		root = insert(root,value);
	}
	
	/**
	 * 在指定结点出插入值，若其左结点不存在，则插入在左结点，
	 * 若右结点不存在，则插入在右结点，否则递归至其各个子结点
	 * @param node
	 * @param value
	 * @return
	 */
	protected TreeNode<T> insert(TreeNode<T> node , T value) {
		if(node == null) {
			size ++;
			node = new TreeNode<T>(value);
		}else {
			if(node.getLeft() == null) {
				node.setLeft(insert(node.getLeft() , value));
			}else if(node.getRight() == null){
				node.setRight(insert(node.getRight() , value));
			}else {
				insert(node.getLeft() , value);
			}
		}
		return node;
	}
	
	
	@Override
	public TreeNode<T> find(T value) {
		if(value == null) {
			return null;
		}
		if(root == null) {
			return null;
		}
		return find0(root , value);
	}
	
	private TreeNode<T> find0(TreeNode<T> node , T value) {
		return null;
	}

	/**
	 * 删除指定父结点的子结点
	 * @param parents
	 * @param child
	 */
	protected void deleteNode(TreeNode<T> parents , TreeNode<T> child) {
		if (child == null) {
			return;
		}
		// 如果右子树为空，则直接连接其左子树
		if (child.getRight() == null) {
			parents.setLeft(child.getLeft());
		} else {
			// 如果左子树为空，则直接连接其右子树
			if (child.getLeft() == null) {
				parents.setLeft(child.getRight());
			} else {
				// 遍历寻找待删除的结点的左结点的最右结点
				TreeNode<T> left = child.getLeft();
				while(left.getRight() != null) {
					left = left.getRight();
				}
				left.setRight(child.getRight());
				parents.setLeft(left);
			}
		}
	}

	@Override
	public void display() {
		Util.print_r(new PreOrderTraverse().traverse(this));
	}
	
	/**
	 * 默认采用的是此先序遍历的方式
	 * @param node
	 *//*
	private void display0(TreeNode<T> node) {
		if(node == null) {
			return ;
		}else {
			visit(node);
			display0(node.getLeft());
			display0(node.getRight());
		}
	}
	
	protected void visit(TreeNode<T> node) {
		if(node != null) {
			System.out.println(node.getValue());
		}
	}
*/
	
	
}
