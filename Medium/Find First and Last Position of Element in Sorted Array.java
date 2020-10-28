class Solution {
    public int[] searchRange(int[] nums, int target) {
      int[] index = {-1,-1};

        if(nums.length == 0) return index;
        if(nums.length == 1)
            if(nums[0] == target){
                index[0] = 0;index[1] =0;
                return index;
        }
        for(int i = 0;i<nums.length;i++)
            if(nums[i] == target){
                if(index[0] == -1)
                    index[0] = i;
                if(nums[i]==target)
                    index[1] = i;
            }
        return index; 
    }
}