package datastructure.tree.impl;

import static org.junit.Assert.fail;

import org.junit.Test;

import datastructure.tree.TraverseStrategy;
import datastructure.tree.TreeNode;
import datastructure.tree.traverse.InOrderTraverse;
import datastructure.tree.traverse.PostOrderTraverse;
import datastructure.tree.traverse.PreOrderTraverse;
import datastructure.util.Util;

public class LinkedBinaryTreeTest {

	@Test
	public void testDisplay() {
		fail("Not yet implemented");
	}

	@Test
	public void testLinkedBinaryTree() {
		TreeNode<Integer> root = new TreeNode<Integer>(2);
		LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<Integer>(root);
		TreeNode<Integer> leftNode = tree.insertLeftNode(root , 5);
		tree.insertRightNode(root , 3);
		tree.insertLeftNode(leftNode, 1);
		tree.insertRightNode(leftNode, 4);
		TraverseStrategy ts = new PreOrderTraverse();
		System.out.println("root node is : " + tree.root().getValue());
		tree.display();
		//Util.print_r(ts.traverse(tree));
		/*System.out.println("删除后");
		tree.deleteLeftNode(root);
		System.out.println("root node is : " + tree.root().getValue());
		Util.print_r(ts.traverse(tree));*/
	}

	@Test
	public void testInsertLeftNodeT() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertRightNodeT() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertLeftNodeTreeNodeOfTT() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertRightNodeTreeNodeOfTT() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteLeftNode() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteRightNode() {
		fail("Not yet implemented");
	}

}
