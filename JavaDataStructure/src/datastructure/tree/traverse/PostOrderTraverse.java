package datastructure.tree.traverse;

import datastructure.tree.TreeNode;

public class PostOrderTraverse extends AbstractTraverseStrategy {

	@Override
	protected <T> void traverse(TreeNode<T> root, StringBuilder sb) {
		if(root != null) {
			traverse(root.getLeft() , sb);
			traverse(root.getRight() , sb);
			visit(root , sb);
		}
	}

}
