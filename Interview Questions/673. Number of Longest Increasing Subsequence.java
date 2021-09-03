class Solution {
    public int findNumberOfLIS(int[] array) {
        int[] dp = new int[array.length];
        int[] counts = new int[array.length];
        int max = 1;
        for(int i = 0;i<dp.length;i++){
            dp[i] = 1;
            counts[i] = 1;
            for(int j = 0;j<i;j++){
                if(array[i] > array[j]){
                    max = Math.max(max,dp[j] + 1);
                    if(dp[i] == dp[j] + 1){
                        counts[i] += counts[j];
                    }else if(dp[j] + 1 > dp[i]){
                        counts[i] = counts[j];
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }

        int result = 0;
        for(int i = 0;i<counts.length;i++){
            result += dp[i] == max ? counts[i] : 0;
        }

        return result;
 
    }
}