class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if(n == 1)
            return matrix[0][0];
        int[][] dp = new int[n][n];
        
        int min = 1000;
        for(int col = 0;col<n;col++){
            dp[n-1][col] = matrix[n-1][col];
        }
        
        for(int row = n-2;row>=0;row--){
            for(int col = n-1;col>=0;col--){
               dp[row][col] = dp[row+1][col];
                
                if(col != 0)
                    dp[row][col] = Math.min(dp[row][col],dp[row+1][col-1]);
                if(col != n-1)
                    dp[row][col] = Math.min(dp[row][col],dp[row+1][col+1]);
                
                dp[row][col] += matrix[row][col];
                if(row == 0)
                    min = Math.min(min,dp[row][col]);
            }
        }
        
        return min;
}
}

