class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(sr,sc,newColor,image,new boolean[image.length][image[0].length],image[sr][sc]);
        
        return image;
    }
    
    private void dfs(int i,int j,int newColor,int[][] grid,boolean[][] visited,int color){
        if(i < 0 || i>=grid.length || j<0 || j>=grid[0].length)
            return;
        
        if(grid[i][j] != color || visited[i][j])
            return;
        
        visited[i][j] = true;
        grid[i][j] = newColor;
        dfs(i+1,j,newColor,grid,visited,color);
        dfs(i-1,j,newColor,grid,visited,color);
        dfs(i,j+1,newColor,grid,visited,color);
        dfs(i,j-1,newColor,grid,visited,color);
    
    }
}