package datastructure.tree.traverse;

import datastructure.tree.TraverseStrategy;
import datastructure.tree.Tree;
import datastructure.tree.TreeNode;

public abstract class AbstractTraverseStrategy implements TraverseStrategy {

	protected <T> void visit(TreeNode<T> node , StringBuilder sb) {
		if (node != null) {
			sb.append(node.getValue() + ",");
		}
	}
	
	@Override
	public <T> String[] traverse(Tree<T> tree) {
		TreeNode<T> root = tree.root();
		StringBuilder sb = new StringBuilder("");
		if(root == null) {
			return sb.toString().split(",");
		}
		traverse(root , sb);
		sb.deleteCharAt(sb.lastIndexOf(","));
		return sb.toString().split(",");
	}
	
	protected abstract <T> void traverse(TreeNode<T> root , StringBuilder sb);
}
