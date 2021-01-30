class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> originalQueue;
    Stack<Integer> temp;
    int size;
    public MyQueue() {
        originalQueue = new Stack<>();
        temp = new Stack<>();
        size = 0;
    }

    public void push(int x) { //   2  3  4 5
        originalQueue.push(x);
        size = originalQueue.size();
    }

    public int pop() {
        int tempSize = size;
        while (tempSize!=1){
            temp.push(originalQueue.pop());// 3  2  1
            tempSize--;
        }
        int value = originalQueue.pop();
        while (!temp.empty()){
            originalQueue.push(temp.pop());
        }
        size = originalQueue.size();
        return value;
    }

    public int peek() {
        int tempSize = size;
        while (tempSize!=0){
            temp.push(originalQueue.pop());
            tempSize--;
        }
        int value = temp.peek();
        while (!temp.empty()){
            originalQueue.push(temp.pop());
        }
        size = originalQueue.size();
        return value;
    }

    public boolean empty() {
        return originalQueue.empty();
    

    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */