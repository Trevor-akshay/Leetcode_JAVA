class Solution {
    public String tictactoe(int[][] moves) {
        char[][] board = new char[3][3];
        
        int player = 0;
        for(var move : moves){
            if(player == 0)
                board[move[0]][move[1]] = 'X';
            else
                board[move[0]][move[1]] = 'O';
            
            player = player == 0 ? 1 : 0;
        }
        
        boolean pending = false;
        
        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                char c = board[i][j];
                if(c == 'X' || c == 'O'){
                    int row = i;
                    int count = 0;
                    while(row < 3 && board[row][j] == c){                        
                        row++;
                        count++;
                    }
                    row = i - 1;
                    while(row >= 0 && board[row][j] == c){
                        row--;
                        count++;
                    }
                    if(count == 3)
                        return c == 'X' ? "A" : "B";
                    count = 0;
                    int col = j;
                    while(col < 3 && board[i][col] == c){
                         col++;
                        count++;
                    }
                    col = j-1;
                    while(col >= 0 && board[i][col] == c){
                        col--;
                        count++;
                    }
                    if(count == 3)
                        return c == 'X' ? "A" : "B";

                     row = i;
                    col = j;
                    count = 0;

                    while(row < 3 && col < 3 && board[row][col] == c){
                        row++;col++;
                        count++;
                    }
                    row = i-1;
                    col = j-1;
                    while(row >= 0 && col >= 0 && board[row][col] == c){
                        row--;col--;
                        count++;
                    }
                    if(count == 3)
                        return c == 'X' ? "A" : "B";
                    count = 0;
                    row = i;
                    col = j;
                    while(row < 3 && col >= 0 && board[row][col] == c){
                        row++;col--;
                        count++;
                    }
                    row = i - 1;
                    col = j + 1;
                    while(row >= 0 && col < 3 && board[row][col] == c){
                        row--;col++;
                        count++;
                    }
                    if(count == 3)
                        return c == 'X' ? "A" : "B";
                                                
                }else
                    pending = true;
            }
        }
        
        return !pending ? "Draw" : "Pending";
    }
}