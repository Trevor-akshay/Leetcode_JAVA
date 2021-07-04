class Solution {
    public int maxProductDifference(int[] nums) {
       int min = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE;
        for(var item : nums){
           if(min > item){
               smin = min;
               min = item;
           }
            else if(smin > item)
                smin = item;
        }
        int max = -1;
        int smax = -2;
        for(var item : nums){
            if(max < item){
                smax = max;
                max = item;
            }
            else if(item > smax)
                smax = item;
        }
        return (max * smax) - (min * smin);
    }
}