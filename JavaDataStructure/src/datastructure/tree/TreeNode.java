package datastructure.tree;

/**
 * @Description 二叉树的结点
 * @author mastery
 * @Date 2015年7月16日下午8:56:45
 */
public class TreeNode<T> {

	private T value;
	
	private TreeNode<T> left;
	
	private TreeNode<T> right;

	public TreeNode() {
		super();
	}

	public TreeNode(T data) {
		super();
		this.value = data;
	}

	public TreeNode(T data, TreeNode<T> left) {
		super();
		this.value = data;
		this.left = left;
	}

	public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
		super();
		this.value = data;
		this.left = left;
		this.right = right;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public TreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	public TreeNode<T> getRight() {
		return right;
	}

	public void setRight(TreeNode<T> right) {
		this.right = right;
	}
	
	public static <E> TreeNode<E> createNode(E value) {
		return new TreeNode<E>(value);
	}
	
}
