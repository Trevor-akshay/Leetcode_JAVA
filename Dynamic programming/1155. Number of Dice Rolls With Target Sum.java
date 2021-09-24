class Solution {
    private final int MOD = (int)(1e9 + 7);
    Integer[][] memo;
    public int numRollsToTarget(int d, int f, int target) {
        memo = new Integer[d + 1][target + 1];
        return helper(d,f,target);
    }
    
    private int helper(int d,int f,int target){
        if(target == 0 && d == 0)
            return 1;
        else if(target < 0 || d == 0)
            return 0;
        
        if(memo[d][target] == null){
            int count = 0;
            for(int i = 1;i<=f;i++)
                count = (count + helper(d - 1,f,target - i)) % MOD;    
            
            memo[d][target] = count;
        }
        return memo[d][target];
    }
}