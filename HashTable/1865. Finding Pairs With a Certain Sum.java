class FindSumPairs {
    int[] nums1, nums2;
    HashMap<Integer, Integer> freq = new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        for (int x : nums2) increaseFreq(x, 1);
    }
    private void increaseFreq(int key, int inc) {
        freq.put(key, freq.getOrDefault(key, 0) + inc);
    }
    public void add(int index, int val) {
        increaseFreq(nums2[index], -1);  
        nums2[index] += val;
        increaseFreq(nums2[index], 1); 
    }
    public int count(int tot) {
        int ans = 0;
        for (int a : nums1)
            ans += freq.getOrDefault(tot - a, 0);
        return ans;
    }
}
// 1 1 2 2 2 3
// 1 4 5 2 5 4
// 7 - 2 - > 5 : (2,2) , (2,4) , ( 3,2) , ( 3,4) , (4,2) , (4,4)
// 7 - 3 -> 4 : (5,1) , ( 5, 4)

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */