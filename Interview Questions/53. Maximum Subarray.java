class Solution {
    public int maxSubArray(int[] nums) {
      //if(nums.length < 2)
        int result = nums[0];
    int[] sum =  new int[nums.length];
    sum[0] = nums[0];
 
    for(int i=1; i<nums.length; i++){
        sum[i] = Math.max(nums[i], sum[i-1] + nums[i]);
        result = Math.max(result, sum[i]);
    }
 
    return result;
        }
    }