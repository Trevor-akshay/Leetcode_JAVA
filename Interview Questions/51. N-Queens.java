class Solution {
    List<List<String>> list = new ArrayList<>();
    int[][] board;
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        board = new int[n][n];
        boolean[] columns = new boolean[n];
        boolean[] diagonals1 = new boolean[2 * n];
        boolean[] diagonals2 = new boolean[2 * n];
        helper(0,columns,diagonals1,diagonals2);
        
        return list;
    }
    
    private void helper(int row,boolean[] columns,boolean[] diagonals1,
                        boolean[] diagonals2){
        if(row == n){
            printPath();
        }

        for(int col = 0;col<n;col++){
            int id1 = col - row + n;
            int id2 = col + row;
            if(columns[col] || diagonals1[id1] || diagonals2[id2])
                continue;

            board[row][col] = 1;
            columns[col] = true;
            diagonals1[id1] = true;
            diagonals2[id2] = true;

            helper(row+1,columns,diagonals1,diagonals2);

            columns[col] = false;
            diagonals1[id1] = false;
            diagonals2[id2] = false;
            board[row][col] = 0;

        }
    } 
    private void printPath(){
        List<String> temp = new ArrayList<>();
        for(var in : board){
            StringBuilder s = new StringBuilder();
            for(var i : in){
                if(i == 1){
                    s.append("Q");
                }else
                    s.append(".");
            }
            temp.add(s.toString());
        }
        list.add(temp);
        
    }
    }
