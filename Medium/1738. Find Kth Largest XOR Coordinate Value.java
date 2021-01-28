class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int m = matrix.length ;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        Queue<Integer> q = new PriorityQueue<>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = matrix[i][j];
                }
                else if(i == 0){
                    dp[i][j] = dp[i][j-1] ^ matrix[i][j];
                }
                else if(j == 0){
                    dp[i][j] = dp[i-1][j] ^ matrix[i][j];
                }
                else{
                    dp[i][j] = dp[i-1][j-1] ^ dp[i][j-1] ^ dp[i-1][j] ^ matrix[i][j];
                }
                if(q.size() < k){
                    q.offer(dp[i][j]);
                }
                else{
                    int c = q.poll();
                    if(c > dp[i][j]){
                        q.offer(c);
                    }
                    else{
                        q.offer(dp[i][j]);
                    }
                }
            }
        }
        return q.poll();
    }
}