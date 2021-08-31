class Solution {
    public int[][] matrixBlockSum(int[][] matrix, int k) {
        int n = matrix.length,m = matrix[0].length;
        int[][] prefixSum  = new int[n][m];
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
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                int row = i + k < n ? i + k : n - 1;
                int col = j + k < m ? j + k : m - 1;

                int temp = prefixSum[row][col];
                int tempRow = row;
                int tempCol = j - k - 1;
                int count = 0;
                
                if(tempCol >= 0) {
                    temp -= prefixSum[tempRow][tempCol];
                    count++;
                }

                tempRow = i - k - 1;
                tempCol = col;
                if(tempRow >= 0) {
                    temp -= prefixSum[tempRow][tempCol];
                    count++;
                }
                tempCol = j - k - 1;
                tempRow = i - k - 1;
                if(count == 2){
                    temp += prefixSum[tempRow][tempCol];
                }

                matrix[i][j] = temp;
            }
        }

        return matrix;
    }
}