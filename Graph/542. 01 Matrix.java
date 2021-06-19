class Solution {
    int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j] == 0){
                    q.offer(new int[]{i,j,0});
                    visited[i][j] = true;
                }
            }
        }
        
        while(!q.isEmpty()){
            var popped = q.poll();
            int i = popped[0];
            int j = popped[1];
            int dist = popped[2];
            mat[i][j] = dist;
            for(int k = 0;k<4;k++){
                if(isValid(i+dir[k][0],j+dir[k][1],mat,visited)){
                    visited[i+dir[k][0]][j+dir[k][1]] = true;
                    q.offer(new int[]{i+dir[k][0],j+dir[k][1],dist + 1});
                }
            }
        }
        
        return mat;
    }
    
    private boolean isValid(int i,int j,int[][] mat,boolean[][] visited){
        return i >= 0 && j >= 0 && i < mat.length && j < mat[0].length 
            && !visited[i][j];
    }
}