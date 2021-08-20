class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        return Math.max(helper(0,nums.length-2,nums,new Integer[nums.length + 1]),
                       helper(1,nums.length-1,nums,new Integer[nums.length + 1]));
    }
    
    private int helper(int start,int end,int[] nums,Integer[] memo){
        if(start > end)
            return 0;
        else if(memo[start] != null)
            return memo[start];
            
        int p1 = nums[start] + helper(start + 2,end,nums,memo);
        int p2 = helper(start + 1,end,nums,memo);
        
        memo[start] = Math.max(p1,p2);
        return memo[start];
    }
    //2 3 2
    //T   T
    //  F   T
}