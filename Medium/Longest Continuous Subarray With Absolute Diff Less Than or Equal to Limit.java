class Solution {
    public int longestSubarray(int[] nums, int limit) {
     int max,min,n,i,j;
        n = nums.length;
        max = 1;
        min = Integer.MAX_VALUE;
        int len = 1;
        for(i=0;i<n;i++){    
            if(len > nums.length - i ) 
                return len;
            for(j=i;j<n;j++){
                max = Math.max(nums[j],max);
                min = Math.min(nums[j],min);
                if(Math.abs(max-min)<=limit)
                    len = Math.max(j-i+1,len);
                else
                {
                    max = 1;
                    min = Integer.MAX_VALUE;
                    break;
                }
            }   
        }
        return len;  
    }
}