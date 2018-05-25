package com.pranav.javagrok.problemsolving;

public class MultiLinkedList {
	class Node{
		Node up;
		Node down;
		Node next;
		Node prev;
		private int val;
		
		public Node(int val) {
			this.val = val;
		}
	}
}
