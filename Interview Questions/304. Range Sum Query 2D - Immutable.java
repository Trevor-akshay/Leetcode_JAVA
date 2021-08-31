class NumMatrix {
    int[][] prefixSum;
    public NumMatrix(int[][] matrix) {
        int n = matrix.length,m = matrix[0].length;
        prefixSum  = new int[n][m];
        prefixSum[0][0] = matrix[0][0];
        
        for(int i = 1;i<n;i++){
            prefixSum[i][0] = prefixSum[i-1][0] + matrix[i][0];    
        }
        
        for(int j = 1;j<m;j++){
            prefixSum[0][j] = prefixSum[0][j-1] + matrix[0][j];
        }
        
        for(int i = 1;i<n;i++){
            for(int j = 1;j<m;j++){
                prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - 
                                  prefixSum[i-1][j-1] + matrix[i][j];
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int temp = prefixSum[row2][col2];
        if(row1 != 0 && col1 != 0){
            temp -= prefixSum[row1-1][col2] + prefixSum[row2][col1-1];
            temp += prefixSum[row1 - 1][col1 - 1];
        }else if(row1 != 0){
            temp -= prefixSum[row1-1][col2];
        }else if(col1 != 0){
            temp -= prefixSum[row2][col1 - 1];
        }
        return temp;
        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */