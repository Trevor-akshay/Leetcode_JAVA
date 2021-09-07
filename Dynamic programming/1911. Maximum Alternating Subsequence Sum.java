class Solution {
    public long maxAlternatingSum(int[] nums) {
        Long[][] memo = new Long[nums.length][2];
        return helper(0,nums,false,memo);
    }
    
    private long helper(int index,int[] nums,boolean chosen,Long[][] memo){
        if(index == nums.length)
            return 0;
        
        int tempIndex = chosen ? 0 : 1;
        if(memo[index][tempIndex] != null)
            return memo[index][tempIndex];
        
        long c1 = 0;
        if(chosen){
            c1 = helper(index + 1,nums,!chosen,memo) - nums[index];
        }else{
            c1 = helper(index + 1,nums,!chosen,memo) + nums[index];
        }
        
        long c2 = helper(index + 1,nums,chosen,memo);
        
        return memo[index][tempIndex] = Math.max(c1,c2);
    }
}