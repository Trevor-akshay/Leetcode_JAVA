class Solution {
    public int findMin(int[] nums) {
        int left = 0,
            right = nums.length -1;
        
        while(left < right){
            int mid = (left + right) / 2;
            if(mid != 0 && nums[left] > nums[mid] && 
               nums[right] > nums[mid] && nums[mid-1] > nums[mid])
                return nums[mid];
            else if(nums[mid] <= nums[right])
                right = mid-1;
            else
                left = mid+1;
        }
        return nums[left];
    } // 3 1 2
}