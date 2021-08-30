class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int k = 2;
        Integer[][][] memo = new Integer[n][k + 1][2];
        return helper(0,prices,memo,k,1);
    }
    
    //flag (0 = sell / 1 = buy);
    private int helper(int index,int[] prices,Integer[][][] memo,int k,int flag){
        if(index == prices.length || k == -1)
            return 0;
        
        if(memo[index][k][flag] != null)
            return memo[index][k][flag];
        
        int buy = 0 , skipBuy = 0 , sell = 0 , skipSell = 0;
        if(flag == 0){
            sell = helper(index + 1,prices, memo,k,1) + prices[index];
            skipSell = helper(index + 1,prices , memo , k , 0);
        }else{
            buy = helper(index + 1,prices, memo , k - 1, 0) - prices[index];
            skipBuy = helper(index + 1,prices, memo , k,1);
        }
        
        return memo[index][k][flag] = Math.max(Math.max(buy,skipBuy),Math.max(sell,skipSell));
    }
}