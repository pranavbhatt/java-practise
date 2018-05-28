package com.pranav.javagrok;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.pranav.javagrok.problemsolving.MultiLinkedList;
import com.pranav.javagrok.problemsolving.MultiLinkedListNode;

class MultiLinkedListTest {

	@Test
	void test() {
		MultiLinkedListNode n1 = new MultiLinkedListNode(1);
		MultiLinkedListNode n2 = new MultiLinkedListNode(2);
		MultiLinkedListNode n3 = new MultiLinkedListNode(3);
		MultiLinkedListNode n4 = new MultiLinkedListNode(4);
		MultiLinkedListNode n5 = new MultiLinkedListNode(5);
		MultiLinkedListNode n6 = new MultiLinkedListNode(6);
		MultiLinkedListNode n7 = new MultiLinkedListNode(7);
		MultiLinkedListNode n8 = new MultiLinkedListNode(8);

		n1.next = n2;
		n2.prev  = n1;
		
		
		n2.next = n3;
		n3.prev = n2;
		
		n3.next = n4;
		n4.prev = n3;
		
		n3.up = n5;
		n5.bottom = n3;
		
		n5.prev = n6;
		n6.next = n5;
		
		n4.bottom = n7;
		n7.up = n4;
		
		n7.prev = n8;
		n8.next  = n7;
		
		int count = 0;
		MultiLinkedListNode t = n1;
		
		while(t != null) {
			t = t.next;
			count++;
		}
		
		Assertions.assertEquals(4, count);
		MultiLinkedList ml = new MultiLinkedList();
		ml.flatten(n1);
		
		count = 0;
		t = n1;
		
		while(t != null) {
			t = t.next;
			count++;
		}
		
		Assertions.assertEquals(8, count);
	}

}
