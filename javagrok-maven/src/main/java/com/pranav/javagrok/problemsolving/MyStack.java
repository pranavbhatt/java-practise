package com.pranav.javagrok.problemsolving;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/implement-stack-using-queues/description/
 * @author pbhatt
 *
 */
class MyStack {
    Queue<Integer> queue;
    /** Initialize your data structure here. */
    public MyStack() {
        this.queue = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        while(size > 1){
            queue.add(queue.remove());
            size--;
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove();
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}