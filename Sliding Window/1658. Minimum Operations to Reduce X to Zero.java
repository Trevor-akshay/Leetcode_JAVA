class Solution {
    public int minOperations(int[] nums, int x) {
       int sum = 0;
        for(int item : nums)
            sum+=item;

        int target = sum - x;

        int left = 0,right=0;
        int temp = 0;
        int length = Integer.MIN_VALUE;
        while(right < nums.length){
            temp += nums[right];

            while (left <= right && temp > target){
                temp-=nums[left++];
            }
            if(temp == target)
                length = Math.max(length,right-left+1);

            right++;
        }

        return length == Integer.MIN_VALUE ? -1 : nums.length-length;
    }
}