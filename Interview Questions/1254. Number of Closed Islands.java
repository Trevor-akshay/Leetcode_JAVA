class Solution {
    int islands = 0;
    public int closedIsland(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 0){
                    if(dfs(i,j,grid)){
                        islands++;
                    }}}
        }

        return islands;
    }
    
    private boolean dfs(int i,int j,int[][] grid){
        if(i < 0 || i>=grid.length || j <0 || j>=grid[0].length)
            return false;

        if(grid[i][j] == 1)
            return true;

        
        grid[i][j] = 1;
        return dfs(i+1,j,grid) &
                    dfs(i-1,j,grid) &
                    dfs(i,j+1,grid) &
                    dfs(i,j-1,grid);
        
        
    }
}