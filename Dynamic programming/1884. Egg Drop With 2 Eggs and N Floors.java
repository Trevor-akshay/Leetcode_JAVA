class Solution {
    public int twoEggDrop(int n) {
        int[][] memo = new int[n + 1][3];
        return helper(n,2,memo);
    }
    
    private int helper(int n,int eggs,int[][] memo){
        if(n <= 1 || eggs == 1)
            return n;
        if(memo[n][eggs] == 0){
            int min = Integer.MAX_VALUE;
            for(int floors = 1;floors <= n;floors++)
                min = Math.min(min,1 + Math.max(helper(floors - 1 , eggs - 1, memo),
                                               helper(n - floors , eggs,memo)));
            
            memo[n][eggs] = min;
        }
        
        return memo[n][eggs];
    }
}