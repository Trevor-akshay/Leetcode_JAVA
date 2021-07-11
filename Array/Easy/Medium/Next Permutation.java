class Solution {
     public void nextPermutation(int[] nums) {
        for(int i = nums.length - 1; i > 0; i--){
            if(nums[i] > nums[i-1]){
                int j = nums.length -1;
                while(j > i-1 && nums[j] <= nums[i-1] ){
                    j--;
                }
                swap(nums,i-1,j);
                reverse(nums, i);
                return;
            }
        }
        
        reverse(nums, 0);
    }
    
    
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}