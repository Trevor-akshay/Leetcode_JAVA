class MyStack {

    /** Initialize your data structure here. */
    Deque<Integer> queue;
    int size;
    public MyStack() {
        queue = new LinkedList<>();
        size = 0;
    }

    /** Push element x onto stack. */
    public void push(int x) { // 1  2
        queue.addFirst(x);
        size = queue.size();
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.removeFirst();
    }

    /** Get the top element. */
    public int top() {
        return queue.peekFirst();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    }


/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */