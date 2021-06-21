class Solution {
    int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
    int length = 1;
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] cache = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                length = Math.max(dfs(i,j,matrix,cache),length);
            }
        }
        
        return length;
    }
    
    private int dfs(int i,int j,int[][] matrix,int[][] cache){
        if(cache[i][j] != 0)
            return cache[i][j];
        
        int max = 1;
        for(int k = 0;k<4;k++){
            int newI = i+dir[k][0];
            int newJ = j+dir[k][1];
            
            if(newI < 0 || newJ < 0 || 
               newI >= matrix.length || newJ >= matrix[0].length || 
               matrix[i][j] >= matrix[newI][newJ])
                continue;
            
            int temp =  dfs(newI,newJ,matrix,cache) + 1;
            max = Math.max(max,temp);
        }
        cache[i][j] = max;
        return max;
    }
}