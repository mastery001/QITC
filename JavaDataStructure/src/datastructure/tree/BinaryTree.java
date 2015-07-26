package datastructure.tree;

public interface BinaryTree<T> extends Tree<T>{

/*	*//**
	 * 按某种次序访问当前二叉树的每个结点，且每个结点只访问一次，访问结点时要实现的具体操作
	 * 由TraverseStrategy接口的实现类完成。
	 * 二叉树的遍历次序主要有先序遍历次序、中序遍历次序，后序遍历次序和层序遍历次序四种。
	 * @param strategy按某种次序访问当前二叉树的每个结点，且每个结点只访问一次，
	 * @return
	 *//*
	String[] traverse(TraverseStrategy strategy);*/
	
	TreeNode<T> insertLeftNode(TreeNode<T> curr, T data);
	
	TreeNode<T> insertRightNode(TreeNode<T> curr, T data);
	
	TreeNode<T> deleteLeftNode(TreeNode<T> curr);
	
	TreeNode<T> deleteRightNode(TreeNode<T> curr);

	/**
	 * 默认从根结点插入左结点
	 * @param data
	 * @return
	 */
	//Tree<T> insertLeftNode(T data);
	
	/**
	 * 默认从根结点插入右结点
	 * @param data
	 * @return
	 */
	//Tree<T> insertRightNode(T data);
}
