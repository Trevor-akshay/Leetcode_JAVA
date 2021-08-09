class Solution {
    public boolean checkMove(char[][] board, int r, int c, char color) {
        int m = board.length;
        int n = board[0].length;
        
        int row = r;
        int col = c;
        //North Direction
        if(row>=2 && board[row-1][col] != '.' && board[row-1][col] != color) {
            row = r-2;
            while(row>=0) {
                if(board[row][col] == color) return true;
                else if(board[row][col] == '.') break;
                row--;
            }
        }
        
        row = r;
        col = c;
        //South Direction
        if((row+2)<m && board[row+1][col] != '.' && board[row+1][col] != color) {
            row = r+2;
            while(row < m) {
                if(board[row][col] == color) return true;
                else if(board[row][col] == '.') break;
                row++;
            }
        }
        
        row = r;
        col = c;
        //West Direction
        if(col>=2 && board[row][col-1] != '.' && board[row][col-1] != color) {
            col = c-2;
            while(col >= 0) {
                if(board[row][col] == color) return true;
                else if(board[row][col] == '.') break;
                col--;
            }
        }
        
        row = r;
        col = c;
        //East Direction
        if((col+2)<n && board[row][col+1] != '.' && board[row][col+1] != color) {
            col = c+2;
            while(col >= 0) {
                if(board[row][col] == color) return true;
                else if(board[row][col] == '.') break;
                col++;
            }
        }
        
        row = r;
        col = c;
        //North - West Direction
        if(row>=2 && col>=2 && board[row-1][col-1] != '.' && board[row-1][col-1] != color) {
            row = r-2;
            col = c-2;
            while(row >= 0 && col>=0) {
                if(board[row][col] == color) return true;
                else if(board[row][col] == '.') break;
                row--;
                col--;
            }
        }
        
        row = r;
        col = c;
        //North - East Direction
        if(row>=2 && (col+2)<n && board[row-1][col+1] != '.' && board[row-1][col+1] != color) {
            row = r-2;
            col = c+2;
            while(row >= 0 && col<n) {
                if(board[row][col] == color) return true;
                else if(board[row][col] == '.') break;
                row--;
                col++;
            }
        }
        
        row = r;
        col = c;
        //South - West Direction
        if((row+2)<m && col>=2 && board[row+1][col-1] != '.' && board[row+1][c-1] != color) {
            row = r+2;
            col = c-2;
            while(row<m && col>=0) {
                if(board[row][col] == color) return true;
                else if(board[row][col] == '.') break;
                row++;
                col--;
            }
        }
        
        row = r;
        col = c;
        //South - East Direction
        if((row+2)<m && (col+2)<n && board[row+1][col+1] != '.' && board[row+1][col+1] != color) {
            row = r+2;
            col = c+2;
            while(row<m && col<n) {
                if(board[row][col] == color) return true;
                else if(board[row][col] == '.') break;
                row++;
                col++;
            }
        }
        
        return false;
    }
}