package com.pranav.javagrok.datastructures;

public class MyQueue {
	public static class QueueFullException extends Exception{

		/**
		 * 
		 */
		private static final long serialVersionUID = -7957984501839975711L;
	}
	public static class NoSuchElementException extends Exception{

		/**
		 * 
		 */
		private static final long serialVersionUID = -7957964501839975711L;
	}
	private int[] array;
	private int top, end, capacity,size;
	
	public MyQueue(int size) {
		this.capacity = size;
		this.size = 0;
		this.array =  new int[size];
		this.end = this.top = 0;
	}
	
	public void enqueue(int x) throws QueueFullException {
		if(this.isFull()) {
			throw new QueueFullException();
		}		
		this.array[end] = x;
		end = (end+1)%this.capacity;
		this.size++;
	}
	
	public int size() {
		return this.size;
	}
	
	public int dequeue() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		int result = this.array[this.top];
		if(this.top == this.end) {
			//we have the last element
			this.top = this.end = 0;
		}else {
			this.top = (this.top+1)%this.capacity;
		}
		this.size--;
		return result;	
	}
	
	public int peek() throws NoSuchElementException {
		if(isEmpty()) throw new NoSuchElementException();
		return array[this.top];
	}
	
	public boolean isFull() {
		return (this.end+1)%this.capacity == this.top;
	}
	
	private boolean isEmpty() {
		return this.top == 0 && this.end == 0;
	}
}
