class Solution {
    public int minFallingPathSum(int[][] grid) {
        if(grid[0].length == 1)
            return grid[0][0];
        int min = 999;
        Integer[][] memo = new Integer[grid.length][grid.length];
        for(int i = 0;i<grid.length;i++)
            min = Math.min(min,helper(grid,0,i,memo));
        
        return min;
    }
    
    private int helper(int[][] grid,int row,int col,Integer[][] memo){
        if(row == grid.length)
            return 0;
        if(memo[row][col] != null)
            return memo[row][col];
        int min = 9999;
        for(int i = 0;i<grid.length;i++){
            if(i != col){
                min = Math.min(min,grid[row][i] + helper(grid,row + 1,i,memo));
            }
        }
        
        return memo[row][col] = min;
    }
}