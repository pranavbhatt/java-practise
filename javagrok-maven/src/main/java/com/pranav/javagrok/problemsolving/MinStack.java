package com.pranav.javagrok.problemsolving;

/**
 * https://leetcode.com/problems/min-stack/description/
 * @author pbhatt
 *
 */
public class MinStack {
    Node head;
    
    class Node{
        int val;
        int min; //min of all elements below it, including itself
        Node next;
        
        public Node(int val, int min){
            this.val = val;
            this.min = min;
        }
    }
    
    /** initialize your data structure here. */
    public MinStack() {
        head = new Node(-1,-1);
    }
    
    public void push(int x) {
        Node n = new Node(x,x);
        n.min = Math.min(n.min, getMin());        
        n.next = head.next;
        head.next = n;
    }
    
    public void pop() {
        head.next = head.next.next;
    }
    
    public int top() {
        if(head.next !=null) return head.next.val;
        return -1;
    }
    
    public int getMin() {
        if(head.next != null) return head.next.min;
        return Integer.MAX_VALUE;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */