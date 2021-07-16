class Solution {
    public boolean find132pattern(int[] nums) {
       if(nums == null || nums.length < 3) {
            return false;
        }
        
        for(int i = 0; i < nums.length - 2; i++) {
            int bigger = nums[i];    
            for(int j = i + 1; j < nums.length; j++) {
                // 1. We don't care about numbers
                // less than a[i]
                if(nums[j] <= nums[i]) continue;
                
                // 2. If num is greater than bigger
                // then update bigger
                if(nums[j] >= bigger) {
                    bigger = nums[j];
                } else {
                    // Now this number is greater than nums[i]
                    // see 1. and less than bigger, see 2.
                    return true;
                }  
            }
        }
        return false;
    }
    
}