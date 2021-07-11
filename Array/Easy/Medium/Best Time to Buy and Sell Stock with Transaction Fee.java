class Solution {
    public int maxProfit(int[] prices, int fee) {
       int maxProfit = 0, cashLeft = -prices[0];
        
        for (int i = 1; i < prices.length; i++) {       
            maxProfit = Math.max(maxProfit, cashLeft + prices[i] - fee);
            cashLeft = Math.max(cashLeft, maxProfit - prices[i]);
        }
    
        return maxProfit;
    }
}