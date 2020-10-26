class Solution {
    public int[] runningSum(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        int j = 0;
        for(int  i = 1; i<nums.length ; i++){
           
            sum[i] = sum[j++] + nums[i];
        }
        return sum;
    }
}