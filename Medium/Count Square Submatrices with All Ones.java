class Solution {
    public int countSquares(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int count  = 0;
        for(int i = 0;i<matrix.length;i++){
            dp[i][0] = matrix[i][0];
            count = dp[i][0] == 1? count+1:count;
        }

        for(int j = 1;j<matrix[0].length;j++){
            dp[0][j] = matrix[0][j];
            count = dp[0][j] == 1? count+1:count;
        }
        

        for(int i = 1;i<dp.length;i++){
            for(int j=1;j<dp[i].length;j++){
                if(matrix[i][j] == 0){
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = Math.min(dp[i][j-1],Math.min(dp[i-1][j-1],dp[i-1][j]))+1;
                count +=dp[i][j];
            }
        }
       
        return count;
    }
}