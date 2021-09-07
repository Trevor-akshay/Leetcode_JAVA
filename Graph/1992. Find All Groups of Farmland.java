class Solution {
    List<int[]> list = new ArrayList<>();
    int x,y;
    public int[][] findFarmland(int[][] land) {
        for(int i = 0;i<land.length;i++){
            for(int j = 0;j<land[0].length;j++){
                if(land[i][j] == 1){
                    x = 0;y = 0;
                    dfs(i,j,land);
                    list.add(new int[]{i,j,x,y});
                }
            }
        }
            
	    return list.toArray(new int[0][]);
    }
    
    private void dfs(int i,int j,int[][] land){
        if(i < 0 || j < 0 || i == land.length || j == land[0].length || land[i][j] == 0)
            return;
        x = Math.max(x,i);
        y = Math.max(y,j);
        land[i][j] = 0;
        dfs(i + 1,j,land);
        dfs(i - 1,j,land);
        dfs(i,j + 1,land);
        dfs(i,j - 1,land);
    }
}