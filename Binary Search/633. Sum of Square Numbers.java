class Solution {
    public boolean judgeSquareSum(int c) {
        int x = 0;
        int y = (int)Math.sqrt(c);
        while(x <= y){
            int power = (x * x) + (y * y);
            if(power == c)
                return true;
            else if(power > c)
                y--;
            else
                x++;
        }
        
        return false;
    }
}