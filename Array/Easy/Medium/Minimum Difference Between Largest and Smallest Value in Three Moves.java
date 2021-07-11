class Solution {
    public int minDifference(int[] nums) {
       
        if (nums.length <= 4) return 0;
        Arrays.sort(nums);
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        min = Math.min(min, nums[len-4]-nums[0]); 
        min = Math.min(min, nums[len-3]-nums[1]);
        min = Math.min(min, nums[len-1]-nums[3]); 
        min = Math.min(min, nums[len-2]-nums[2]); 
        
        return min;
    }
}