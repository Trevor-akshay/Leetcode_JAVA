class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int index = 0;
        for(int i = nums.length-1;i>=0;i--)
            if(nums[i] == 1){
                index = i;
                break;
            }
        for(int i = index-1;i>=0;i--){
            if(nums[i] ==  1){
               if((index-1) - i < k)
                    return false;
                index = i;
            }
        }
        return true;
    }
}