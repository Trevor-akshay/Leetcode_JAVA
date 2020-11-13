class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        int row = grid.length,column = grid[0].length;
        int value = 0;
        while(k>0) {
            for (int i = row - 1; i >= 0; i--) {
                if (i == row - 1) {
                    value = grid[i][column - 1];
                    k--;
                }
                for (int j = column - 1; j > 0; j--) {
                    grid[i][j] = grid[i][j - 1];
                }
                if (i > 0)
                grid[i][0] = grid[i - 1][column - 1];
            }
            grid[0][0] = value;
        }
        for(int[] inner : grid){
            List<Integer> list = new LinkedList<>();
            for(int item : inner){
                list.add(item);
            }
            lists.add(list);
        }
        //System.out.println(Arrays.deepToString(grid));
        return lists;
    }
}