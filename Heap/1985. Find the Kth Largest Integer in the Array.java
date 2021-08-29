class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums,
               (a,b) -> a.length() == b.length() ? a.compareTo(b) : a.length() - b.length()
        );
        return nums[nums.length - k];
    }
}



class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> q = new PriorityQueue<>(
                (a,b) -> a.length() == b.length() ? a.compareTo(b): a.length() - b.length()
        );
        for(var num : nums) {
            q.offer(num);
            if(q.size() > k)
                q.poll();

        }
        
        return q.peek();
    }
}