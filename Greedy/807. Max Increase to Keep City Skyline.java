class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] xMax = new int[n];
        int[] yMax = new int[n];
        
        for(int i = 0;i<n;i++){
            for(int j= 0;j<n;j++){
                xMax[i] = Math.max(xMax[i],grid[i][j]);
                yMax[j] = Math.max(yMax[j],grid[i][j]);
            }
        }
        
        int total = 0;

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                total += Math.min(xMax[i],yMax[j]) - grid[i][j];
            }
        }
        
        return total;
    }
}