class Solution {
    int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] p = new boolean[n][m];
        boolean[][] a = new boolean[n][m];
        for(int i = 0;i<n;i++){
            dfs(i,0,p,heights,Integer.MIN_VALUE);
            dfs(i,m-1,a,heights,Integer.MIN_VALUE);
        }
        for(int j = 0;j<m;j++){
            dfs(0,j,p,heights,Integer.MIN_VALUE);
            dfs(n-1,j,a,heights,Integer.MIN_VALUE);
        }
        
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(p[i][j] && a[i][j])
                    list.add(Arrays.asList(i,j));
            }
        }
        
        return list;
        
    }
    
    private void dfs(int i,int j,boolean[][] visited,int[][] h,int parent){
        if(h[i][j] < parent)
            return;
        visited[i][j] = true;
        for(int k = 0;k<4;k++){
            int x = i + d[k][0];
            int y = j + d[k][1];
            if(isValid(x,y,visited)){
                dfs(x,y,visited,h,h[i][j]);
            }
        }
    }
    
    private boolean isValid(int i,int j,boolean[][] v){
        return i >= 0 && j >= 0 && i < v.length && j < v[0].length && !v[i][j];
    }
}