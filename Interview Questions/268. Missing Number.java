class Solution {
    public int missingNumber(int[] nums) {
        if(nums[0] == 0 && nums.length < 2 )
            return 1;
        if(nums.length < 2)
            return 0;
        int value = 0;
        int sum = 0;
        Arrays.sort(nums);
        for(int i = nums[0];i<=nums[nums.length-1];i++)
            value = value + i;
        for(int j = 0;j<nums.length;j++)
            sum = sum+ nums[j];
        return value-sum;
    }
}