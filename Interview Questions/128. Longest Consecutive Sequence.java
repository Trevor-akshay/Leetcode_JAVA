class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int maxLen = 1;
        int prevNum = nums[0];
        int tempLen = 1;
        for(int i=1; i<nums.length;i++){
           
            if(nums[i] == nums[i-1]){
                continue;
            }
            if(nums[i] == prevNum + 1){
                tempLen++;
                prevNum++;
                maxLen = Math.max(maxLen , tempLen);
            }
            else{
                tempLen = 1;
                prevNum = nums[i];
            }
        }
        return maxLen;
}
}