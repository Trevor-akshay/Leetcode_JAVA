class Solution {
    public boolean isValidSudoku(char[][] board) {
        // row / 3 * 3 + col / 3 = square
        Map<Integer,boolean[]> boxes = new HashMap<>();
        Map<Integer,boolean[]> columns = new HashMap<>();
        Map<Integer,boolean[]> rows = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] =='.')
                    continue;
                int square = ((i / 3) * 3) + (j / 3);
                int value = board[i][j] - '0';
                
                boxes.putIfAbsent(square, new boolean[10]);
                rows.putIfAbsent(i, new boolean[10]);
                columns.putIfAbsent(j, new boolean[10]);
                
                if (boxes.get(square)[value] ||
                    rows.get(i)[value] ||
                    columns.get(j)[value])
                        return false;
                
                boxes.get(square)[value] = true;
                rows.get(i)[value] = true;
                columns.get(j)[value] = true;
            }
        }
        return true;
    }
}
