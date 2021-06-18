class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] visited = new boolean[n][m];
        for(int i = 0;i<n;i++){//Left
            if(grid[i][0] == 1)
                dfs(i,0,grid,visited);
        }
        for(int i = 0;i<n;i++){//Right
            if(grid[i][m-1] == 1)
                dfs(i,m-1,grid,visited);
        }
        for(int j = 0;j<m;j++){//Top
            if(grid[0][j] == 1)
                dfs(0,j,grid,visited);
        }
        for(int j = 0;j<m;j++){//Bottom
            if(grid[n-1][j] == 1)
                dfs(n-1,j,grid,visited);
        }
        
        int enclaves = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1 && !visited[i][j])
                    enclaves++;
            }
        }
        
        return enclaves;
    }
    
    private void dfs(int i,int j,int[][] grid,boolean[][] visited){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return;
        if(grid[i][j] == 0 || visited[i][j])
            return;
        visited[i][j] = true;
        dfs(i+1,j,grid,visited);
        dfs(i-1,j,grid,visited);
        dfs(i,j+1,grid,visited);
        dfs(i,j-1,grid,visited);
    
    }
}