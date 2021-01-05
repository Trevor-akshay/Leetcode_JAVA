class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
            int temp = k;
            for(int i = nums.length-1;i>=0;i--){
                 if(temp == 1)
                       return nums[i];
                 temp--;
            }
            return 0;
    }
}