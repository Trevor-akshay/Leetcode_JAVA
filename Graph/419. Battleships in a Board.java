class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] == 'X'){
                    dfs(i,j,board);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void dfs(int i,int j,char[][] b){
        if(i < 0 || j < 0 || i >= b.length || j >= b[0].length || b[i][j] == '.')
            return;
        
        b[i][j] = '.';
        dfs(i-1,j,b);
        dfs(i+1,j,b);
        dfs(i,j-1,b);
        dfs(i,j+1,b);
    }
}