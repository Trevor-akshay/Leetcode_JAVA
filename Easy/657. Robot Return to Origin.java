class Solution {
    public boolean judgeCircle(String moves) {
      int x = 0,y=0;
        for(char c : moves.toCharArray()){
            if(c == 'R')
                y++;
            else if(c == 'L')
                y--;
            else if(c == 'U')
                x++;
            else
                x--;
        }
        return x == 0 && y == 0;
    }
}