class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] chess = new int[8][8];
        List<List<Integer>> lists = new ArrayList<>();
        for(int[] innerArray : queens){
            int x = innerArray[0] , y = innerArray[1];
            chess[x][y] = 1;
        }
        int x = king[0] ,y = king[1];
        int column = y;
        while (column >= 0){
            if(chess[x][column] == 1){
                lists.add(Arrays.asList(x,column));
                break;
            }
            column--;
        }
        column = y;
        while (column < 8){
            if(chess[x][column] == 1){
                lists.add(Arrays.asList(x,column));
                break;
            }
            column++;
        }
        int top = x;
        while (top >=0){
            if(chess[top][y] == 1){
                lists.add(Arrays.asList(top,y));
                break;
            }
            top--;
        }
        int down = x;
        while (down < 8){
            if(chess[down][y] == 1){
                lists.add(Arrays.asList(down,y));
                break;
            }
            down++;
        }
        int diagonalRightDownX = x;
        int diagonalRightDownY = y;
        while (diagonalRightDownX < 8 && diagonalRightDownY < 8){
            if(chess[diagonalRightDownX][diagonalRightDownY] == 1){
                lists.add(Arrays.asList(diagonalRightDownX,diagonalRightDownY));
                break;
            }
            diagonalRightDownY++;
            diagonalRightDownX++;
        }
        int diagonalLeftUpX = x;
        int diagonalLeftUpY = y;
        while (diagonalLeftUpX >= 0 && diagonalLeftUpY >=0 ){
            if(chess[diagonalLeftUpX][diagonalLeftUpY] == 1){
                lists.add(Arrays.asList(diagonalLeftUpX,diagonalLeftUpY));
                break;
            }
            diagonalLeftUpY--;
            diagonalLeftUpX--;
        }
        int diagonalRightUpX = x;
        int diagonalRightUpY = y;
        while (diagonalRightUpX >=0 && diagonalRightUpY < 8){
            if(chess[diagonalRightUpX][diagonalRightUpY] == 1){
                lists.add(Arrays.asList(diagonalRightUpX,diagonalRightUpY));
                break;
            }
            diagonalRightUpX--;
            diagonalRightUpY++;
        }
        int diagonalLeftDownX = x;
        int diagonalLeftDownY = y;
        while (diagonalLeftDownX < 8 && diagonalLeftDownY >= 0){
            if(chess[diagonalLeftDownX][diagonalLeftDownY] == 1){
                lists.add(Arrays.asList(diagonalLeftDownX,diagonalLeftDownY));
                break;
            }
            diagonalLeftDownX++;
            diagonalLeftDownY--;
        }


        return lists;
    }
    }
