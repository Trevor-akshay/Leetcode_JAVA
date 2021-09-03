class Solution {
    long[][] memo;
    public long maxPoints(int[][] points) {
        memo = new long[points.length][points[0].length];
        long res = 0;
        for (int j = 0; j < points[0].length; j++) 
            res = Math.max(res, dp(points, 0, j));
        
        return res;
    }
    public long dp(int[][] points, int i, int j) {
        if (i == points.length-1) 
            return points[i][j];
        
        if (memo[i][j] != 0) 
            return memo[i][j];
        
        for (int col = 0; col < points[0].length; col++) {
            memo[i][j] = Math.max(memo[i][j], 
                                  points[i][j]-Math.abs(col-j)+dp(points, i+1, col));
        }
        return memo[i][j];
    }
}