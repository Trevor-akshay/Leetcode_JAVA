class Solution {
    public int nearestExit(char[][] maze, int[] e) {
        int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[]{e[0],e[1],0});
        boolean[][] v = new boolean[maze.length][maze[0].length];
        v[e[0]][e[1]] = true;
        int level = 0;
        while(!q.isEmpty()){
            var poll = q.poll();
            if(level != 0 && (poll[0] == 0 || poll[0] == maze.length - 1 || 
               poll[1] == maze[0].length - 1 || poll[1] == 0))
                return poll[2];
            
            for(int k = 0;k<4;k++){
                int x = d[k][0] + poll[0];
                int y = d[k][1] + poll[1];
                if(isValid(x,y,v,maze)){
                    v[x][y] = true;
                    q.offer(new int[]{x,y,poll[2]+1});
                }
            }
            level++;
        }
            
        return -1;
    }
    
    private boolean isValid(int i,int j,boolean[][] visited,char[][] maze){
        return i >= 0 && j >= 0 
            && i < maze.length && j < maze[0].length && maze[i][j] != '+'
            && !visited[i][j];
    }
}