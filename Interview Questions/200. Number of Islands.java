class Solution {
  int[][] directions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
public int numIslands(char[][] grid) {
    int count = 0;
    if(grid.length == 0 || grid[0].length == 0)
        return count;
    
    for(int row = 0; row < grid.length; row++){
        for(int col = 0; col < grid[0].length; col++){
            if(grid[row][col] == '1'){
                count++;
                DFS(grid, row, col);
            }
        }
    }
    
    return count;    
}

private void DFS(char[][] grid, int row, int col){
    if(row < 0 || row >= grid.length || 
       col < 0 || col >= grid[0].length || 
       grid[row][col] == '0')
        return;
    
    grid[row][col] = '0';
    for(int[] coordinate : directions){
        DFS(grid, row + coordinate[0], col + coordinate[1]);
    }
}
}