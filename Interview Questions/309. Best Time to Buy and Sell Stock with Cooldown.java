class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] memo = new Integer[prices.length + 1][2];
        return helper(0,prices,memo,1);
    }
    //flag 1 = buy , 0 = sell
    private int helper(int index,int[] prices,Integer[][] memo,int flag){
        if(index >= prices.length)
            return 0;
        
        if(memo[index][flag] != null)
            return memo[index][flag];
        
        int buy = 0, skipBuy = 0, sell = 0, skipSell = 0;
        if(flag == 1){
            buy = helper(index + 1,prices,memo,0) - prices[index];
            skipBuy = helper(index + 1,prices,memo,1);
        }else{
            sell = helper(index + 2,prices,memo,1) +  prices[index];
            skipSell = helper(index + 1,prices,memo,0);
        }
        memo[index][flag] = Math.max(Math.max(buy,skipBuy),Math.max(sell,skipSell));
        
        return memo[index][flag];
    }
    
}