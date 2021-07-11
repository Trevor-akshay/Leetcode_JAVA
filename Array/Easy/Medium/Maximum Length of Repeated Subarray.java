class Solution {
    public int findLength(int[] A, int[] B) {
        int m=A.length, n =B.length;
        int[][] dp = new int[m+1][n+1];
        int res=0;
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(A[i-1] ==  B[j-1]){ 
                    dp[i][j] = dp[i-1][j-1] +1; 
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        
        return res;
    }
}