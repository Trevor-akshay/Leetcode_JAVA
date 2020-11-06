class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resultList = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0){
            return resultList;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int matrixSize = matrix.length * matrix[0].length;
        while(resultList.size() < matrixSize){
            for(int index = left; index <= right && resultList.size() < matrixSize; index++){
                resultList.add(matrix[top][index]);
            }
            top++;
            for(int index = top; index <= bottom && resultList.size() < matrixSize; index++){
                resultList.add(matrix[index][right]);
            }
            right--;
            for(int index = right; index >= left && resultList.size() < matrixSize; index--){
                resultList.add(matrix[bottom][index]);
            }
            bottom--;
            for(int index = bottom; index >= top && resultList.size() < matrixSize; index--){
                resultList.add(matrix[index][left]);
            }
            left++;
        }
        return resultList;
    }
}