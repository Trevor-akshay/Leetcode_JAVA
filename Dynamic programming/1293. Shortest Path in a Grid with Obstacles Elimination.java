class Solution {
    private final int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    Integer[][][] memo;
    public int shortestPath(int[][] grid, int k) {
        memo = new Integer[grid.length][grid[0].length][k + 1];
        int res = dfs(0,0,grid,k,new boolean[grid.length][grid[0].length]);
        
        return res == (int)1e4 ? -1 : res;
    }
    
    private int dfs(int i,int j,int[][] grid,int k,boolean[][] seen){
        if(i == grid.length - 1 && j == grid[0].length - 1){
            return 0 ;
        }
        
        if(memo[i][j][k] != null)
            return memo[i][j][k];
        
        if(grid[i][j] == 1){
            if(k == 0)
                return (int)1e4;
            k--;
        }
        
        seen[i][j] = true;
        int min = (int)1e4;
        for(int m = 0;m<4;m++){
            int newRow = i + dir[m][0];
            int newCol = j + dir[m][1];
            if(isValid(newRow,newCol,grid,k,seen))
                min = Math.min(min,1 + dfs(newRow,newCol,grid,k,seen));
        }
        seen[i][j] = false;
        return memo[i][j][k] = min;
    }
    
    private boolean isValid(int i,int j,int[][] grid,int k,boolean[][] seen){
       return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && !seen[i][j];
    }
}