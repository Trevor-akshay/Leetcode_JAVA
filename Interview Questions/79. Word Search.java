class Solution {
    static  final int[] X = {0,1,0,-1};
    static final  int[] Y = {1,0,-1,0};
    boolean found = false;
    
    public boolean exist(char[][] board, String word) {
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                dfs(i,j,board,word,new ArrayList<>(),
                    new boolean[board.length][board[0].length],0);
                if(found)
                    return true;
            }
        }    
        
        return false;
    }
    
    private void dfs(int i,int j,char[][] board,String word,
                     List<Character> list, boolean[][] visited,int index){
        
        
        if(board[i][j] != word.charAt(index)){
            return;
        }
        if(index == word.length()-1){
            found = true;
            return;
        }
        list.add(board[i][j]);

        visited[i][j] = true;;
        
        for(int k = 0;k<4;k++){
           if(isValid(i+X[k],j+Y[k],board,visited)){
                dfs(i+X[k],j+Y[k],board,word,list,visited,index+1);

            }
        }
        list.remove(list.size()-1);
        visited[i][j] = false;
    }
    
    private boolean isValid(int i,int j,char[][] board,boolean[][] visited){
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length
            && !visited[i][j];
    }
    
    
}
