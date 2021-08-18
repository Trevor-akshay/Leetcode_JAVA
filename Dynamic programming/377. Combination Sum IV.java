class Solution {
    int size  = 0;
    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target + 1];
        Arrays.fill(memo,-2);
        return helper(memo,nums,target);
    }
    
    private int helper(int[] memo,int[] nums,int target){
        if(target < 0)
            return 0;
        else if(target == 0)
            return 1;
        else if(memo[target] != -2)
            return memo[target];
        for(var num : nums){
            if(memo[target] == -2)
                memo[target] = 0;
            memo[target] += helper(memo,nums,target-num);
        }
        return memo[target];
    }
}