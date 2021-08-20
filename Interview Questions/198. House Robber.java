class Solution {
    public int rob(int[] nums) {
        Integer[] memo = new Integer[nums.length];
        return helper(0,nums,memo);
    }
    
    private int helper(int index,int[] nums,Integer[] memo){
        if(index >= nums.length)
            return 0;
        else if(memo[index] != null)
            return memo[index];
        int p1 = nums[index] + helper(index+2,nums,memo);
        int p2 = helper(index + 1,nums,memo);
        
        memo[index] = Math.max(p1,p2);
        
        return memo[index];
    }
}