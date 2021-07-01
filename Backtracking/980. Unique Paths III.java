class Solution {
    int res = 0;
    int obs = 0;
    public int uniquePathsIII(int[][] grid) {
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 0)
                    obs++;
            }
        }
        Outer : for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    helper(i,j,grid,new boolean[grid.length][grid[0].length]);
                    break Outer;
                }
            }
        }
        return res;
    }
    private void helper(int i,int j,int[][] grid,boolean[][] visited){
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length 
           || grid[i][j] == -1 || visited[i][j])
            return;
        if(grid[i][j] == 2){
            if(obs == 0){
                res++;
            }
            return;
        }
        visited[i][j] = true;
        if(grid[i][j] == 0)
            obs--;
        helper(i+1,j,grid,visited);
        helper(i-1,j,grid,visited);
        helper(i,j+1,grid,visited);
        helper(i,j-1,grid,visited);
        visited[i][j] = false;
        if(grid[i][j] == 0)
            obs++;

    }
}