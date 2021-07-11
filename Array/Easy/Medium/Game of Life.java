class Solution {
    public void gameOfLife(int[][] board) {
        int[][] tempBoard = new int[board.length][board[0].length];
        int row = board.length,col = board[0].length;
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                int count = 0;
                if(i<row-1)//ROW Down
                    if(board[i+1][j] == 1)
                    count++;

                if(i>=1)// ROw up
                    if(board[i-1][j] == 1)
                    count++;
                if(i>=1 & j<col-1)//diag right
                    if(board[i-1][j+1] == 1)
                        count++;
                if(i>=1 & j>=1)//diag left
                    if(board[i-1][j-1] == 1)
                        count++;

                if(j>=1)// col left
                    if(board[i][j-1] == 1)
                    count++;

                if(j<col-1)//col right
                    if(board[i][j+1] == 1)
                    count++;
                if(i<row-1 & j>=1)//diag down left
                    if(board[i+1][j-1] == 1)
                        count++;
                if(i<row-1 & j<col-1)//diag down right
                    if(board[i+1][j+1] == 1)
                        count++;

                if(count < 2 || count > 3)
                    tempBoard[i][j] = 0;
                else if(count  == 3 & board[i][j] == 0)
                    tempBoard[i][j] = 1;
                else if((count == 3 || count == 2) & board[i][j] == 1)
                    tempBoard[i][j] = 1;

            }
        }

        System.arraycopy(tempBoard,0,board,0,board.length);
        //System.out.println(Arrays.deepToString(board));
    }
}