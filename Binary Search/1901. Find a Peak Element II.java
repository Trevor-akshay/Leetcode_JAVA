class Solution {
    
    public int[] findPeakGrid(int[][] mat) {
        int lowCol = 0;
        int highCol = mat[0].length - 1;
        
        while(lowCol <= highCol) {
            int midCol = lowCol + (highCol - lowCol) / 2;
            int maxRow = 0;
            for(int i = 0; i < mat.length; i++) {
                maxRow = mat[i][midCol] > mat[maxRow][midCol] ? i : maxRow;
            }
            
            boolean isLeftElementBig = midCol - 1 >= lowCol && mat[maxRow][midCol - 1] > mat[maxRow][midCol];
            boolean isRightElementBig = midCol + 1 <= highCol && mat[maxRow][midCol + 1] > mat[maxRow][midCol];
            
            if(!isLeftElementBig && !isRightElementBig) {
                return new int[]{maxRow, midCol};
            } else if(isRightElementBig) {
                lowCol = midCol + 1;
            } else {
                highCol = midCol - 1;
            }
        }
        return null;
    }
}