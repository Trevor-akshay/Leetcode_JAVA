class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> (a[0] + a[1]) - (b[0]+b[1]));
        for (int j : nums1) {
            for (int value : nums2) {
                q.offer(new int[]{j, value});
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        while(k-- > 0  && !q.isEmpty()){
            int[] temp =q.poll();
            result.add(Arrays.asList(temp[0],temp[1]));
        }
        return result;
    }
}