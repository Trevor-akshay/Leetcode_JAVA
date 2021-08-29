class Solution {
    int n = 0;
    int m = 0;
    public int cherryPickup(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        Integer[][][] memo = new Integer[n][m][m];
        return dfs(0,0,m-1,grid,memo);
    }

    private int dfs(int r,int c1,int c2,int[][] grid,Integer[][][] memo){
        if(r == n - 1){
            if(c1 == c2)
                return grid[r][c1];
            return grid[r][c1] + grid[r][c2];
        }
        else if(memo[r][c1][c2] != null)
            return memo[r][c1][c2];
        
        int result = 0;

        for(int i = -1;i<=1;i++){
            for(int j = -1;j<=1;j++){
                int newC1 = c1 + i;
                int newC2 = c2 + j;
                if(newC1 >= 0 && newC2 >= 0 && newC1 < m && newC2 < m)
                    result = Math.max(result,dfs(r+1,newC1,newC2,grid,memo));
            }
        }
        result += c1 == c2 ? grid[r][c1] : grid[r][c1] + grid[r][c2];
        return memo[r][c1][c2] = result;
    }
}
