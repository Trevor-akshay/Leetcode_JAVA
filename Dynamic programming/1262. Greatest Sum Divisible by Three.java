class Solution {
    public int maxSumDivThree(int[] nums) {
        int[][] memo = new int[nums.length][3];
        for(var m : memo)
            Arrays.fill(m,-1);
        return helper(0,nums,memo,0);
    }
    
    private int helper(int index,int[] nums,int[][] memo,int sum){
        if(index == nums.length){
            return sum == 0 ? 0 : -1;
        }
        if(memo[index][sum] != -1)
            return memo[index][sum];
        
        int included = helper(index + 1,nums,memo,(sum + nums[index]) % 3);
        if(included != -1)
            included +=nums[index];
        int excluded = helper(index + 1,nums,memo,sum % 3);
        memo[index][sum] = Math.max(included,excluded);
        
        return memo[index][sum];
    }
}