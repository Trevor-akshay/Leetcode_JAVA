class Solution {
    public int cherryPickup(int[][] grid) {
       int n = grid.length;
       Integer[][][][] dp = new Integer[n][n][n][n];
       return Math.max(0,helper(0,0,0,0,grid,dp));
    }

    private int helper(int r1,int c1,int r2,int c2,int[][] grid,Integer[][][][] dp) {
        if(r1 == grid.length || c1 == grid[0].length || grid[r1][c1] == -1 ||
                r2 == grid.length || c2 == grid[0].length || grid[r2][c2] == -1)
            return Integer.MIN_VALUE;
        
        if(dp[r1][c1][r2][c2] != null)
            return dp[r1][c1][r2][c2];
        
        if(r1 == grid.length-1 && c1 == grid[0].length-1)
            return grid[r1][c1];
        if(r2 == grid.length-1 && c2 == grid[0].length-1)
            return grid[r2][c2];

        int cherries = 0;
        if(r1 == r2 && c1 == c2)
            cherries =  grid[r1][c1];
        else
            cherries = grid[r1][c1] + grid[r2][c2];

        cherries += Math.max(
                Math.max(helper(r1+1,c1,r2+1,c2,grid,dp),helper(r1+1,c1,r2,c2+1,grid,dp)),
                Math.max(helper(r1,c1+1,r2,c2+1,grid,dp),helper(r1,c1+1,r2+1,c2,grid,dp))
        );
        dp[r1][c1][r2][c2] = cherries;
        return dp[r1][c1][r2][c2]; 
    }
}