class Solution {
    public int maxEnvelopes(int[][] e) {
        Arrays.sort(e,
                (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
        );
        int n = e.length;
        int[] dp = new int[n + 1];
        int max = 1;
        for(int i = 0;i<n;i++){
            dp[i] = 1;
            for(int j = 0;j<i;j++){
                if(e[i][0] > e[j][0] && e[i][1] > e[j][1]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                    max = Math.max(max,dp[i]);
                }
            }
        }
        
        return max;
    }
}