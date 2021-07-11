class Solution {
    public int longestSubarray(int[] nums) {
     int prev = 0;
        int curr = 0;
        int max = 0;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] == 1){
                curr++;
                if(curr + prev > max) max = curr + prev;
            }
            else if(nums[i] == 0){
                prev = curr;
                curr = 0;
            }
        }
        if(max == nums.length) return max - 1;
        return max;
    }
}