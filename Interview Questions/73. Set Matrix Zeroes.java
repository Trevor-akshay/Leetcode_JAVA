class Solution {
    public void setZeroes(int[][] matrix) {
         List<List<Integer>> coordinates = new ArrayList<>();

        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[i].length;j++){
                if(matrix[i][j] == 0)
                    coordinates.add(Arrays.asList(i,j));
            }
        }
        for(List<Integer> list : coordinates){
            int row = list.get(0),col=list.get(1);

            int top = row;
            while(top >= 0)
                matrix[top--][col] = 0;

            int down = row;
            while (down < matrix.length)
                matrix[down++][col] = 0;

            int left = col;
            while (left >= 0)
                matrix[row][left--] = 0;

            int right = col;
            while (right < matrix[0].length)
                matrix[row][right++] = 0;
        }

        //System.out.println(Arrays.deepToString(matrix));
    }
}