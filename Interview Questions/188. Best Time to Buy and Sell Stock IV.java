class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(k > n / 2){
            return maxHelperInfinity(prices,n);
        }
        Integer[][][] memo = new Integer[n][k+1][2];
        return helper(0,prices,memo,k,0);
    }
    
    private int maxHelperInfinity(int[] prices,int n){
        int max = 0;
        for(int i = 1;i<n;i++){
            int temp = prices[i] - prices[i-1];
            max += temp > 0 ? temp : 0;
        }
        return max;
    }
    
    //flag (0 == sell / 1 == buy)
    private int helper(int index,int[] prices,Integer[][][] memo,int k,int flag){
        if(index == prices.length || k == -1)
            return 0;
        if(memo[index][k][flag] != null)
            return memo[index][k][flag];
        
        int buy = 0 , skipBuy = 0, sell = 0 , skipSell = 0;
        if(flag == 1){
            sell = helper(index + 1,prices,memo,k,0) + prices[index];
            skipSell = helper(index + 1,prices,memo,k,1);
        }else{
            buy = helper(index + 1,prices,memo,k - 1,1) - prices[index];
            skipBuy = helper(index + 1,prices,memo,k,0);
        }
        
        memo[index][k][flag] = Math.max(Math.max(buy,skipBuy),Math.max(sell,skipSell));
        
        return memo[index][k][flag];               
    }
}