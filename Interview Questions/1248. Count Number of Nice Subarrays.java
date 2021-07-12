class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        int tempCount = 0;
        for(;right<nums.length;right++){
            k = nums[right] % 2 == 1 ? k - 1 : k;
            if(k == 0){
                tempCount = 0;
                while(left < nums.length && k == 0){
                    k = nums[left++] % 2 == 0 ? k  : k+1;
                    tempCount++;
                }
                count += tempCount;
            }else
                count += tempCount;
        }
        return count;
    }
}