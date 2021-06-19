class Solution {
    public int maxProfit(int[] prices) {
         int discount =0;
        int k =0;
      for(int i = 1;i<prices.length;i++){
                if(prices[i]<prices[k]){
                    k = i;
                    continue;
                }
                else{
                    discount = Math.max(discount,prices[i]-prices[k]);
                }
            }
            return discount;
    }
}