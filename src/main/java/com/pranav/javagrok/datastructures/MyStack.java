package com.pranav.javagrok.datastructures;

class StackOverFlowException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5113181344879947667L;
}

class StackEmptyException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8010739419930831590L;}

public class MyStack {
	int top, capacity;
	int[] array;
	public MyStack(int size) {
		this.capacity = size;
		top = -1;
		this.array = new int[size];
	}
	
	@SuppressWarnings("unused")
	private void push(int x) throws StackOverFlowException {
		if(isFull()) throw new StackOverFlowException();  
		this.array[++top] = x;
	}
	
	@SuppressWarnings("unused")
	private int pop() throws StackEmptyException{
		if(this.isEmpty()) throw new StackEmptyException();
		int result = this.array[this.top--];
		return result;
	}
	
	private boolean isEmpty() {
		return this.top == -1;
	}
	
	private boolean isFull() {
		return this.top == capacity-1;
	}
}
