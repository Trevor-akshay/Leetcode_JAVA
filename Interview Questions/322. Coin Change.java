class Solution {
    public int coinChange(int[] coins, int amount) {
      Integer[][] memo = new Integer[coins.length][amount + 1];
        int res = helper(0,memo,coins,amount);
        return  res == (int)1e4 ? -1 : res;
    }

    static private int helper(int index,Integer[][] memo,int[] coins,int amount){
        if(amount == 0)
            return 0;
        else if(amount < 0 || index == coins.length)
            return (int)1e4;
        if(memo[index][amount] == null){
            int p1 = 1 + helper(index,memo,coins,amount - coins[index]);
            int p2 = helper(index + 1,memo,coins,amount);
            
            memo[index][amount] = Math.min(p1,p2);
        }
        return memo[index][amount];
    }
}