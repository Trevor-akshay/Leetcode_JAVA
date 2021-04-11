class Solution {
    public int arraySign(int[] nums) {
        int product = 1;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0)
                return 0;
            product *= nums[i] >= 1 ? 1 : -1;

            }
        
        return product == 1 ? 1 : -1;
    }
}