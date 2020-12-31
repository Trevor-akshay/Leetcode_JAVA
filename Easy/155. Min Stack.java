class MinStack {

    /** initialize your data structure here. */
    LinkedList<Integer> list;
    public MinStack() {
        list = new LinkedList<>();
    }
    public void push(int x) {
        list.add(x);
    }
    public void pop() {
        list.removeLast();
    }
    public int top() {
        return list.get(list.size()-1);
    }
    public int getMin() {   
        int min = Integer.MAX_VALUE;
        for(int item : list)
            if(min > item )
                min = item;
        return min;    
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */