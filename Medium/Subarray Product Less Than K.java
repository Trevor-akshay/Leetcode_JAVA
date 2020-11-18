class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0; // 10  2  5  6
        int product = 1, count = 0, j = 0;
        for (int i = 0; i < nums.length; i++) {//3
            product *= nums[i];//500

            while (product >= k){
                product /= nums[j++];//50
                 }
            count += i - j + 1;
        }
        return count;//8
    }}