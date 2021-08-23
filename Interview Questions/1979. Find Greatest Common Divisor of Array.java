class Solution {
    public int findGCD(int[] nums) {
     int min = 1000;
        int max = 0;
        for(var num : nums){
            min = Math.min(min,num);
            max = Math.max(max,num);
        }
        return getGCD(max,min);
    }
    
    private int getGCD(int x,int y){
        if(x == 0)
            return y;
        
        return getGCD(y%x,x);
    }
}