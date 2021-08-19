class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] memo = new Integer[coins.length][amount + 1];

        return helper(0,memo,coins,amount);
    }

    private int helper(int index,Integer[][] memo,int[] coins,int amount){
        if(amount == 0)
            return 1;
        else if(index == coins.length || amount < 0)
            return 0;
        else if(memo[index][amount] != null)    
            return memo[index][amount];
        int including = helper(index,memo,coins,amount - coins[index]);
        int excluding = helper(index + 1,memo,coins,amount);
        
        memo[index][amount] = including + excluding;

        return memo[index][amount];
    }
    
}