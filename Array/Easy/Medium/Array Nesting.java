class Solution {
    public int arrayNesting(int[] nums) {
    int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MIN_VALUE) {
                int index = nums[i], tempCount = 0;
                while (nums[index] != Integer.MIN_VALUE) {
                    int temp = index;
                    index = nums[index];
                    tempCount++;
                    nums[temp] = Integer.MIN_VALUE;
                }
                count = Math.max(count, tempCount);
            }
        }
        return count;
    }
}