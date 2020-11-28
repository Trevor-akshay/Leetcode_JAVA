class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
    dp[0][0] = grid[0][0];
    for(int i = 1;i<grid.length;i++)
        dp[i][0] = grid[i][0] + dp[i-1][0];
    for(int j = 1;j<grid[0].length;j++)
        dp[0][j] = grid[0][j] + dp[0][j-1];

    for(int i =1;i<grid.length;i++){
        for(int j = 1;j<grid[i].length;j++){
            dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
        }
    }
    //System.out.println(Arrays.deepToString(dp));

    return dp[dp.length-1][dp[0].length-1];
    }
}