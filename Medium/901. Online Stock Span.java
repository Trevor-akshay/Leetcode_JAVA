class StockSpanner {

     Map<Integer,Integer> map;
    Stack<Integer> stack;
    int index = 0;
    public StockSpanner() {
        map = new HashMap<>();
        stack =new Stack<>();
        index = 0;
    }

    public int next(int price) {
        map.put(price,index++);
        while (!stack.empty() && price>=stack.peek())
            stack.pop();
        int temp=stack.isEmpty()?index:index-1-(map.get(stack.peek()));
        stack.push(price);
        return temp;
}
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */