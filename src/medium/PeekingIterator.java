package medium;

import java.util.Iterator;

/*
 * https://leetcode.com/problems/peeking-iterator/description/
 */
//Java Iterator interface reference:
//https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
	private Iterator<Integer> iterator;
	private Integer cache;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	}

 // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if(cache == null && iterator.hasNext()) cache = iterator.next();
		return cache;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer temp = peek();
	    cache = null;
	    return temp;
	}

	@Override
	public boolean hasNext() {
	    return peek() != null;
	}
}