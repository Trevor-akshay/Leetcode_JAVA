class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int row=mat.length;
        int column=mat[0].length;         // 3  3  1  1
        for(int i=0;i<row;i++) {          // 2  2  1  2
            for(int j=0;j<column;j++) {   // 1  1  1  2
                for(int k=i+1,m=j+1;k<row && m<column;k++,m++) {
                    if(mat[i][j]>mat[k][m]){
                        int temp=mat[i][j];
                        mat[i][j]=mat[k][m];
                        mat[k][m]=temp;    }
                }
            }
        }
        return mat;
	}
}