package com.pranav.javagrok.problemsolving;

import java.util.Iterator;

//Java Iterator interface reference:
//https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
 Integer peek;
 Iterator<Integer> itr;
	public PeekingIterator(Iterator<Integer> iterator) {
	    this.peek = null;
	    this.itr = iterator;
	}

 // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {        
     if(this.hasNext() && peek == null){
         peek = this.next();
     }
     return peek;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	@Override
	public Integer next() {
     Integer result = null;
	    if(peek != null){
         result = peek;
         peek = null;
     }else{
         result = this.itr.next();
     }
     return result;
	}

	@Override
	public boolean hasNext() {
	    if(peek != null) return true;
     return this.itr.hasNext();
	}
}
