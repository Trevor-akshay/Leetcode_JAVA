class KthLargest {

  PriorityQueue<Integer> queue;
    int size;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>();
        size = k;
        for (int num: nums) fillQueue(queue, num, k);
    }
    
    public int add(int val) {
        fillQueue(queue, val, size);
        return queue.peek();
    }
    
    public void fillQueue(PriorityQueue<Integer> queue, int num, int size) {
        if (queue.size() < size) {
            queue.offer(num);
        } else {
            if (num > queue.peek()) {
                queue.poll();
                queue.offer(num);
            }
        }
    }
}


/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */