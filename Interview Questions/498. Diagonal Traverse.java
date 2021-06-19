class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
      int rowSize = mat.length-1;                               
      int colSize = mat[0].length-1;  
        
      int[] array = new int[(rowSize +1) * (colSize + 1)];      
      int index = 0;
        
      int rowIteration = 0;
      int colIteration = 0;
      boolean upTraversal = true;
        
      while(index < array.length){
          if(upTraversal){
              int tempCol = 0;
              int tempRow = 0;
              while(rowIteration >= 0 && colIteration <= colSize){
                  tempCol = colIteration;
                  tempRow = rowIteration;
                  array[index++] = mat[rowIteration--][colIteration++];
              }
              
              if(colIteration > colSize){
                  rowIteration = tempRow + 1;
                  colIteration = tempCol;
              }else{
                  rowIteration = tempRow;
                  colIteration = tempCol + 1;
              }
              
              upTraversal = false;
          }else{
              int tempRow = 0;
              int tempCol = 0;
              while (rowIteration <= rowSize && colIteration >= 0){
                  tempRow = rowIteration;
                  tempCol = colIteration;
                  array[index++] = mat[rowIteration++][colIteration--];
              }  
              
              if(rowIteration > rowSize){
                  rowIteration = tempRow;
                  colIteration = tempCol + 1;
              }else{
                  rowIteration = tempRow + 1;
                  colIteration = tempCol;
              }
              
              upTraversal = true;

          }
      }
      return array;
    }
}