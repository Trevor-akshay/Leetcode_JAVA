class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix.length==0 || matrix[0].length==0)return res;
        for(int i = 0; i<matrix.length;i++){
            int min = Integer.MAX_VALUE;
            int col = 0;
            for(int j = 0;j<matrix[i].length;j++){
                if(matrix[i][j]<min){
                    col = j;
                    min = matrix[i][j];
                }
            }
            boolean isLucky = true;
            for(int j = 0;j<matrix.length;j++){
                if(matrix[j][col]>min){
                    isLucky = false;
                    break;
                }
            }
            if(isLucky)res.add(matrix[i][col]);
        }
        return res;
    }
}