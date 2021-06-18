class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        
        for(int i = 0;i<n;i++){// Left Border
            if(board[i][0] == 'O')
                dfs(i,0,board,visited);
        }
        for(int i = 0;i<n;i++){// Right Border
            if(board[i][m-1] == 'O')
                dfs(i,m-1,board,visited);
        }
        for(int j = 0;j<m;j++){ // Top Border
            if(board[0][j] == 'O')
                dfs(0,j,board,visited);
        }
        for(int j = 0;j<m;j++){// Bottom Border
            if(board[n-1][j] == 'O')
                dfs(n-1,j,board,visited);
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(board[i][j] == 'O' && !visited[i][j])
                    board[i][j] = 'X';
            }
        }
    }
    
     private void dfs(int i,int j,char[][] board,boolean[][] visited){
        if(i < 0 || i>= board.length || j<0 || j>= board[0].length)
            return;

        if(board[i][j] == 'X')
            return;

        if(visited[i][j])
            return;

        visited[i][j] = true;
        dfs(i+1,j,board,visited);
        dfs(i-1,j,board,visited);
        dfs(i,j-1,board,visited);
        dfs(i,j+1,board,visited);
    }
}