// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    List<Integer> list; 
    int index;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        list = new LinkedList<>();
        while(iterator.hasNext()){
            list.add(iterator.next());
        }
        index = 0;
	    
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return list.get(index);
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	      return list.get(index++);

	}
	
	@Override
	public boolean hasNext() {
	    return index < list.size();
	}
}