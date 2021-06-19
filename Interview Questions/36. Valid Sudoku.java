class Solution {
    public boolean isValidSudoku(char[][] board) {
         int row = 0;
            int col = 0;
            int startCol = 0;
            int startRow = 0;

            int index = 0;
            int charCount = 0;
            char c = ' ';
            while (index < 81) {
                col = index % 9;
                row = index / 9;
                charCount = 0;
                c = board[row][col];

                if (c != '.') {
                    for (int i = 0; i < 9; i++) { 
                        if (board[row][i] == c) {
                            if (charCount > 0) {
                                return false;
                            }
                            charCount++;
                        }
                    }

                    charCount = 0;
                    for (int i = 0; i < 9; i++) { 
                        if (board[i][col] == c) {
                            if (charCount > 0) {
                                return false;
                            }
                            charCount++;
                        }
                    }

                    startCol = (col / 3) * 3;
                    startRow = (row / 3) * 3;
                    charCount = 0;
                    for (int a = startCol; a < startCol + 3; a++) { 
                        for (int b = startRow; b < startRow + 3; b++) {
                            if (board[b][a] == c) {
                                if (charCount > 0) {
                                    return false;
                                }
                                charCount++;
                            }
                        }
                    }
                }

                index++;
            }

            return true;
    }
}