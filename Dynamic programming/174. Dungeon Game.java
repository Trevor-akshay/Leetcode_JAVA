class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        Integer[][] memo = new Integer[dungeon.length][dungeon[0].length];
        return helper(0,0,dungeon,memo);
    }

    private int helper(int i,int j,int[][] dungeon,Integer[][] memo){
        if(i == dungeon.length || j == dungeon[0].length)
            return (int)1e5;
        if(i == dungeon.length-1 && j == dungeon[0].length - 1)
            return dungeon[i][j] < 0 ? -dungeon[i][j] + 1: 1;
        else if(memo[i][j] != null)    
            return memo[i][j];
        
        int p1 = helper(i,j+1,dungeon,memo);
        int p2 = helper(i+1,j,dungeon,memo);
        
        int min = Math.min(p1,p2) - dungeon[i][j];
        
        memo[i][j] =  min <= 0 ? 1 : min;
        return memo[i][j];
}
}