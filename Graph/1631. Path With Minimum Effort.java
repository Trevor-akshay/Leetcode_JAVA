class Solution {
    int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length , m = heights[0].length;
        int[][] distances = new int[n][m];
        for(int i = 0;i<n;i++)
            Arrays.fill(distances[i],Integer.MAX_VALUE);
        
        PriorityQueue<int[]> q = new PriorityQueue<>(
              (a,b) -> a[2] - b[2]
        );
        
        q.offer(new int[]{0,0,0});
        while(!q.isEmpty()){
            var poll = q.poll();
            if(poll[0] == n-1 && poll[1] == m-1){
                return poll[2];
            }
            for(int k = 0;k<4;k++){
                int x = poll[0] + dir[k][0];
                int y = poll[1] + dir[k][1];
                if(x < 0 || y < 0 || x == n || y == m)
                    continue;
                int distance = Math.max(poll[2],Math.abs(heights[x][y] - heights[poll[0]][poll[1]]));
                if(distances[x][y] > distance){
                    distances[x][y] = distance;
                    q.offer(new int[]{x,y,distance});
                }
            }
        }
        return -1;
    }
}