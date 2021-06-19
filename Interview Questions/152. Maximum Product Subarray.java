class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 1) return nums[0];
         int product = 0;
        for(int i =0;i<nums.length;i++){
            product = Math.max(product,nums[i]);
            int value = nums[i];
            for(int j = i+1;j<nums.length;j++){
                value *= nums[j];
                product = Math.max(product,value);
            }
        }
        return product;
    }
}