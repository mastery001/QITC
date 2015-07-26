package datastructure.tree.traverse;

import datastructure.tree.TreeNode;

public class InOrderTraverse extends AbstractTraverseStrategy{

	@Override
	protected <T> void traverse(TreeNode<T> root, StringBuilder sb) {
		if(root != null) {
			traverse(root.getLeft() , sb);
			visit(root , sb);
			traverse(root.getRight() , sb);
		}
	}

}
