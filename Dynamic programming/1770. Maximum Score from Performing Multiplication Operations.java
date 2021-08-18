class Solution {
    public int maximumScore(int[] nums, int[] multi) {
        Integer[][] memo = new Integer[multi.length][multi.length];
        return helper(0,nums.length-1,0,memo,nums,multi,0);
    }
    private int helper(int i,int k,int j,Integer[][] memo,int[] nums,int[] multi,int value){
        if(j == multi.length)
            return 0;

        else if(memo[j][i] != null)
            return memo[j][i];
        
        int sum = nums[i] * multi[j] + helper(i+1,k,j+1,memo,nums,multi,value);
        int sum2 =nums[k] * multi[j] + helper(i,k-1,j+1,memo,nums,multi,value);
        
        return memo[j][i] =  Math.max(sum,sum2);
        
    }
    
}