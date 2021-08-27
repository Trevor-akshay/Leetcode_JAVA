class Solution {
    public int maximalSquare(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        int max = 0;
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(i == 0 || j == 0){
                   dp[i][j] = grid[i][j] == '1' ? 1 : 0;
                   max = Math.max(max,dp[i][j]);
                }
                else if(grid[i][j] == '0')
                    dp[i][j] = 0;
                else{
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1])) + 1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
       
        return max * max;
    }
}