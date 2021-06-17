class MyCircularDeque {

    /** Initialize your data structure here. Set the size of the deque to be k. */
    List<Integer> deque;
    int length;
    public MyCircularDeque(int k) {
        deque = new ArrayList<>();
        length = k;
    }
    public boolean insertFront(int value) {
        if(isFull()) return false;
        deque.add(0,value);
        return true;
    }
    public boolean insertLast(int value) {
        if(isFull()) return false;
        deque.add(deque.size()%length,value);
        return true;
    }
    public boolean deleteFront() {
        if(isEmpty()) return false;
        deque.remove(0);
        return true;
    }
    public boolean deleteLast() {
        if(isEmpty()) return false;
        deque.remove(deque.size()-1);
        return true;
    }
    public int getFront() {
        if(isEmpty()) return -1;
        return deque.get(0);
    }
    public int getRear() {
        if(isEmpty()) return -1;
        return deque.get(deque.size()-1);
    }
    public boolean isEmpty() {
        return deque.isEmpty();
    }
    public boolean isFull() {
        return deque.size() == length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */