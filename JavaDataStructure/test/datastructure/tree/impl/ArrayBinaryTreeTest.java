package datastructure.tree.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import datastructure.tree.Tree;

public class ArrayBinaryTreeTest {

	@Test
	public void testArrayBinaryTree() {
		Integer[] arrs = new Integer[] { 2, 5, 3, 1, 4 };
		Tree<Integer> tree = new ArrayBinaryTree<Integer>(arrs);
		System.out.println("root node is : " + tree.root());
		tree.display();
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testDisplay() {
		fail("Not yet implemented");
	}

}
