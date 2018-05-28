package com.pranav.javagrok.problemsolving;

public class MultiLinkedList {
	
	
	/**
	 * 	4-5-5	
	 *  	|
	 *  1-2-3-4-8
	 *  	|	|
	 *  	6	5
	 *  
	 *  result: 1-2-4-5-5-6-3-4-5-8
	 */
	public MultiLinkedListNode flatten(MultiLinkedListNode root) {
		if(root == null) return null;
		
		MultiLinkedListNode prev = root;
		MultiLinkedListNode curr = root.next;
		
		while(curr != null){	
			MultiLinkedListNode head;
			
			if(curr.up != null) {
				head = removeAndAttach(prev, curr, curr.up);
				curr.up.bottom = null;
				curr.up = null;
				curr = head;
				continue;
			}
			
			if(curr.bottom != null) {
				head = removeAndAttach(prev, curr, curr.bottom);
				curr.bottom.up = null;
				curr.bottom = null;
				curr = head;
				continue;
			}
			
			prev = curr;
			curr = curr.next;
		}
		
		
		return root;
	}
	
	private MultiLinkedListNode removeAndAttach(MultiLinkedListNode prev, MultiLinkedListNode curr, MultiLinkedListNode node) {
		if(prev == null || curr == null || node == null ) return null;
		
		MultiLinkedListNode head = getHead(node);
		MultiLinkedListNode tail = getTail(node);
		prev.next = head;
		head.prev = prev;
		tail.next = curr;
		curr.prev = tail;
		
		return head;
	}
	
	private MultiLinkedListNode getHead(MultiLinkedListNode node) {
		while(node!= null && node.prev != null) {
			node = node.prev;
		}
		return node;
	}
	
	private MultiLinkedListNode getTail(MultiLinkedListNode node) {
		while(node!= null && node.next != null) {
			node = node.next;
		}
		return node;
	}
}
