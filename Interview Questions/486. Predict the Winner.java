class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        Integer[][] memo = new Integer[nums.length][nums.length];
        int player1Sum = helper(0,nums.length-1,nums,memo);
        
        return totalSum - player1Sum <= player1Sum;
    }
    
    private int helper(int i,int j,int[] nums,Integer[][] memo){
        if(i > j)
            return 0;
        else if(i == j)
            return nums[i];
        
        if(memo[i][j] == null){
            int c1 = Math.min(helper(i + 2,j,nums,memo),
                              helper(i + 1,j - 1,nums,memo)) + nums[i];
            int c2 = Math.min(helper(i+1,j - 1,nums,memo),
                              helper(i,j - 2,nums,memo)) + nums[j];
        
            memo[i][j] = Math.max(c1,c2);
        }
        
        return memo[i][j];
    }
}