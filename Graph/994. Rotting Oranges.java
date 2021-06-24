class Solution {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int count = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 2)
                    q.offer(new int[]{i,j});
                
                if(grid[i][j] == 1)
                    count++;
            }
        }
        
        int time = 0;
        while(!q.isEmpty()){
            if(count == 0)
                return time;
            var size = q.size();
            time++;
            for(int m = 0;m<size;m++){
                var i = q.peek()[0];
                var j = q.poll()[1];
                for(int k = 0;k<4;k++){
                    int x = i + dir[k][0];
                    int y = j + dir[k][1];
                    if(x < 0 || y< 0 || x == grid.length || y == grid[0].length)
                        continue;
                    int[] temp = {x,y};

                    if(grid[x][y] == 1){
                        count--;
                        grid[x][y] = 2;
                        q.offer(temp);
                    }
                }
            }
        }
        
       return time == 0 && count == 0? 0 : -1;
    }
}