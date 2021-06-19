class Solution {
    int maxGold = 0;
    public int getMaximumGold(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] != 0){
                    dfs(i,j,grid,visited,0);
                }
            }
        }
        
        return maxGold;
    }
    
    private void dfs(int i,int j,int[][] grid,boolean[][] visited,int temp){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return;
        if(visited[i][j]  || grid[i][j] == 0)
            return;
        
        temp+=grid[i][j];
        maxGold = Math.max(maxGold,temp);
        visited[i][j] = true;
        dfs(i+1,j,grid,visited,temp);
        dfs(i-1,j,grid,visited,temp);
        dfs(i,j+1,grid,visited,temp);
        dfs(i,j-1,grid,visited,temp);

        visited[i][j] = false;
        temp-=grid[i][j];
    }
}