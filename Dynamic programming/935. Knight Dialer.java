class Solution {
    int mod = (int)(1e9 + 7);
    public int knightDialer(int n) {
        long totalValue = 0;
        Long[][][] memo = new Long[n + 1][4][3];
        for(int i = 0;i<4;i++){
            for(int j = 0;j<3;j++){
                totalValue = (totalValue + helper(i, j, n, memo)) % mod;
            }
        }

        return (int) totalValue;
    }
    private long helper(int i,int j,int n,Long[][][] memo){
        if(i < 0 || j < 0 || i >= 4 || j >= 3 || ( i == 3 && j != 1) )
            return 0;
        else if(memo[n][i][j] != null) {
            return memo[n][i][j];
        }
        if(n == 1) {
            return 1;
        }
        memo[n][i][j] = helper(i + 2,j + 1,n - 1,memo) % mod +
                        helper(i + 2,j - 1,n - 1,memo) % mod +
                        helper(i + 1,j + 2,n - 1,memo) % mod +
                        helper(i + 1,j - 2,n - 1,memo) % mod +
                        helper(i - 2,j + 1,n - 1,memo) % mod +
                        helper(i - 2,j - 1,n - 1,memo) % mod +
                        helper(i - 1,j + 2,n - 1,memo) % mod +
                        helper(i - 1,j - 2,n - 1,memo) % mod;

        return memo[n][i][j];
    }
}