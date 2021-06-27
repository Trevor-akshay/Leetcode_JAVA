class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();
        
        int[][] region = new int[n * 3][m * 3];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i].charAt(j) == '/'){
                    region[i*3+2][j*3] = 1;
                    region[i*3+1][j*3+1] = 1;
                    region[i*3][j*3+2] = 1;
                }else if(grid[i].charAt(j) == '\\'){
                    region[i*3][j*3] = 1;
                    region[i*3+1][j*3+1] = 1;
                    region[i*3+2][j*3+2] = 1;
                }
            }
        }
        int regions = 0;
        for(int i = 0;i<region.length;i++){
            for(int j = 0;j<region[0].length;j++){
                if(region[i][j] == 0){
                    dfs(i,j,region);
                    regions++;
                }
            }
        }
        
        return regions;
    }
    
    private void dfs(int i,int j,int[][] grid){
        if(i < 0 || j < 0 || i == grid.length || j == grid.length || grid[i][j] == 1)
            return;
        
        grid[i][j] = 1;
        
        dfs(i+1,j,grid);
        dfs(i-1,j,grid);
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);
        
    }
}