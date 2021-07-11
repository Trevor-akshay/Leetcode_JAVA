class Solution {
    public void rotate(int[][] matrix) {
        if(matrix.length == 1) return;
       int[][] array = new int[matrix.length][matrix[0].length];
       int k = matrix.length-1,m=0;
       for(int i = matrix.length-1;i>=0;i--){
           for(int j = matrix[0].length-1;j>=0;j--){
               array[k][m] = matrix[j][i];
               m++;
           }
           m=0;
           k--;
       }
       for(int i = 0;i<array.length;i++)
           for(int j =0;j<array[0].length;j++)
               matrix[i][j] = array[i][j];

        
    }
}