class Solution {
    public boolean canBeIncreasing(int[] array) {
        int[] dp = new int[array.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i = 1;i<dp.length;i++){
            for(int j = 0;j<i;j++){
                if(array[j] < array[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i],max);
                }
            }
        }    
        return max >= array.length - 1;
    }
}