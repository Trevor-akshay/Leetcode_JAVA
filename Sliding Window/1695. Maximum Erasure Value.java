class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int left = 0;
        int tempSum = 0;
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                while (nums[left] != num) {
                    set.remove(nums[left]);
                    tempSum -= nums[left++];
                }
                tempSum -= nums[left++];
            }
            tempSum += num;
            sum = Math.max(sum, tempSum);
        }
        return sum;
    }
}