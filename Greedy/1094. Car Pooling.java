class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
       int[] pers = new int[1001];
        
        for(var trip : trips){
            pers[trip[1]] += trip[0];
            pers[trip[2]] -= trip[0];
        }
        
        for(int i = 0;i<1001 && capacity >= 0 ;i++)
            capacity -= pers[i];
        
        return capacity >= 0;
    }
}