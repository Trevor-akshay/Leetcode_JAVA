class Solution {
    
    int[][] grid;
    boolean[][] seen;

    public int area(int row, int column) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length ||
                seen[row][column] || grid[row][column] == 0)
            return 0;
        seen[row][column] = true;
        return (1 + area(row+1, column) + area(row-1, column)
                  + area(row, column-1) + area(row, column+1));
    }

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                ans = Math.max(ans, area(row, column));
            }
        }
        return maxArea;}
}