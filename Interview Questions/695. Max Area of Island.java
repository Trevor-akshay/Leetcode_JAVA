class Solution {
    int[][] direction = {{0,-1},{-1,0},{0,1},{1,0}};
    int tempArea = 0;
    int area = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    tempArea = 0;
                    dfs(i,j,grid);
                }
            }
        }
        return area;
    }
    
    private void dfs(int i,int j,int[][] grid){
        grid[i][j] = 0;
        tempArea++;
        
        for(int k = 0;k<4;k++){
            if(isValid(i+direction[k][0],j+direction[k][1],grid)){
                dfs(i+direction[k][0],j+direction[k][1],grid);
            }
        }
        
        area = Math.max(area,tempArea);
        
    }
    
    private boolean isValid(int i,int j,int[][] grid){
        return i >=0 && i<grid.length && j>=0 && 
            j<grid[0].length && grid[i][j] == 1;
    }
}