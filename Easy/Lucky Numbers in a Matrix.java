class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int row = matrix.length, column = matrix[0].length;
        for(int i =0;i<row;i++){
            int max = matrix[i][0];
            int min = matrix[i][0];
            for(int j=0 ; j<column;j++){
                if(min > matrix[i][j])
                    min = matrix[i][j];
                }
            for(int j=0 ; j<column;j++){
                if(max < matrix[j][i])
                    max = matrix[j][i];
            }
        result.add(max);
        result.add(min);
        }
        for(int i = 0;i<result.size();i++)
            for(int j = i+1;j<result.size();j++)
                if(result.toArray()[i] == result.toArray()[j])
                    list.add((Integer) result.toArray()[i]);

        return list;
    }
}