class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for(int i = 0;i<grid.length;i++){
            int left = 0;
            int right = grid[i].length-1;
            if(grid[i][right] >= 0)
                continue;
            while(left < right){
                int mid = (left + right) / 2;
               if(grid[i][mid] < 0)
                    right = mid;
                else
                    left = mid + 1;
            }
            count+=grid[i].length - right;
        }
            
        return count;
    }
}
