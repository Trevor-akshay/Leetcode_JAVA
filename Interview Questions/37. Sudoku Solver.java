class Solution {
   public void solveSudoku(char[][] board) {
        doSolve(board, 0, 0);
    }
    
    private boolean doSolve(char[][] board, int row, int col) {
        for (int i = row; i < 9; i++, col = 0) { // note: must reset col here!
            for (int j = col; j < 9; j++) {
                if (board[i][j] != '.') continue;
                for (char num = '1'; num <= '9'; num++) {
                    if (isValid(board, i, j, num)) {
                        board[i][j] = num;
                        if (doSolve(board, i, j + 1))
                            return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }
    
    private boolean isValid(char[][] board, int i, int j, char value) {
        int row = i-1;
        while (row >= 0){
            if(board[row][j] == value)
                return false;
            row--;
        }
        row = i+1;
        while (row < board.length){
            if(board[row][j] == value)
                return false;
            row++;
        }
        int col = j-1;
        while (col >= 0){
            if(board[i][col] == value)
                return false;
            col--;
        }
        col = j+1;
        while (col < board[0].length){
            if(board[i][col] == value)
                return false;
            col++;
        }
        int startRow = i - i % 3;
        int startCol = j - j % 3;
        for(row = 0;row < 3;row++){
            for(col = 0;col < 3;col++){
                if(board[startRow + row][startCol + col] == value)
                    return false;
            }
        }
        return true;
    }
}