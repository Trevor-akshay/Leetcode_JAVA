class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(var item : nums){
            if(q.size() < k)
                q.offer(item);
            else if(q.peek() < item){
                q.poll();
                q.offer(item);
            }
        }

        return q.peek();
    }
}