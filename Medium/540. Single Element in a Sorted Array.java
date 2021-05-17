class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0,
            right = nums.length-1;
        
        while(left < right){
            int mid = (left + right) / 2;
            if(mid % 2 == 0 && nums[mid+1] == nums[mid])
                left = mid + 1;
            else if(mid % 2 == 1 && nums[mid-1] == nums[mid])
                left = mid + 1;
            else 
                right = mid;
        }
        
        return nums[left];
    }
}
//                                     1,1,2,3,3,4,4,8,8
//                                         l r