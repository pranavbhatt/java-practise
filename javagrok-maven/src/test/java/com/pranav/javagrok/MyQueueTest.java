package com.pranav.javagrok;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.pranav.javagrok.datastructures.MyQueue;
import com.pranav.javagrok.datastructures.MyQueue.NoSuchElementException;
import com.pranav.javagrok.datastructures.MyQueue.QueueFullException;


class MyQueueTest {
	MyQueue queue;

	@Test
	void testEnqueue() {
		this.queue = new MyQueue(5);
		try {
			queue.enqueue(1);
			queue.enqueue(2);
			queue.enqueue(3);
			queue.enqueue(4);
			this.queue.enqueue(6);
		} catch (QueueFullException e) {
			e.printStackTrace();
		}
		Assertions.assertThrows(QueueFullException.class, () -> {this.queue.enqueue(7);});
		Assertions.assertTrue(queue.isFull());
	}
	
	@Test
	void testDequeue() {
		this.queue = new MyQueue(5);
		Assertions.assertThrows(NoSuchElementException.class, () -> {this.queue.dequeue();});

		int result=0;
		try {
			queue.enqueue(1);
			queue.enqueue(2);
			queue.enqueue(3);
			queue.enqueue(4);
			result = this.queue.dequeue();
		} catch (QueueFullException | NoSuchElementException e) {
			e.printStackTrace();
		}
		Assertions.assertEquals(result, 1);
	}

}
