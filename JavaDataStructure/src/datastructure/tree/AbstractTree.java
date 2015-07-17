package datastructure.tree;

public abstract class AbstractTree<T> implements BinaryTree<T> {

	protected int deep;
	
	protected int size;
	
	protected TreeNode<T> root;
	
	@Override
	public String[] traverse(TraverseStrategy strategy) {
		return strategy.traverse();
	}

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
	public T getRoot() {
		return root.getValue();
	}
	
}
