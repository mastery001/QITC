package datastructure.queue;

import static org.junit.Assert.*;

import org.junit.Test;

import datastructure.exception.StructureException;

public class SequenceQueueTest {

	@Test
	public void testAdd() throws StructureException {
		Queue<Integer> queue = new SequenceQueue<Integer>();
		queue.add(1);
		queue.add(2);
		System.out.println(queue.remove());
		System.out.println(queue.remove());
	}

	@Test
	public void testRemove() {
		fail("尚未实现");
	}

	@Test
	public void testPeek() {
		fail("尚未实现");
	}

}
