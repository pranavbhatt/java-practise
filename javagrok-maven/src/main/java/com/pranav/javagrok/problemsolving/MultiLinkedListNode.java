package com.pranav.javagrok.problemsolving;

public class MultiLinkedListNode {
	public MultiLinkedListNode up;
	public MultiLinkedListNode bottom;
	
	public MultiLinkedListNode next;
	public MultiLinkedListNode prev;

	public int val;

	public MultiLinkedListNode(int val) {
		this.val = val;
	}
}
