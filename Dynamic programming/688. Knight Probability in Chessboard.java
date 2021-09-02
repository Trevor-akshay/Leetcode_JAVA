class Solution {
    private int[][] dir = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
    public double knightProbability(int n, int k, int row, int column) {
        Double[][][] memo = new Double[n][n][k + 1];
        return helper(n,k,row,column,memo);
    }
    
    private double helper(int n,int k,int i,int j,Double[][][] memo){
        if(i < 0 || j < 0 || i >= n || j >= n)
            return 0;
        
        if(k == 0)
            return 1;
        else if(memo[i][j][k] != null)    
            return memo[i][j][k];
            
        double value = 0;
        for(int counter = 0;counter<8;counter++){
            value += 0.125 * helper(n,k - 1,i + dir[counter][0],j + dir[counter][1],memo);
        }
        return memo[i][j][k] = value;
    }
}