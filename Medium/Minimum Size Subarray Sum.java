class Solution {
    public int minSubArrayLen(int s, int[] nums) {
       if(nums.length == 0 || Arrays.stream(nums).sum() < s) return 0;
        int length = Integer.MAX_VALUE;
        int sum = 0;
        for(int item : nums)
            if(item >= s)
                return 1;
        for(int i = 0;i<nums.length;i++){
            sum = nums[i];
            for(int j =i+1;j<nums.length;j++){
                if(sum < s){
                    sum+=nums[j];
                }
                if(sum >= s){
                    length = Math.min(j-i+1,length);
                    }
            }
        }

        return length;
    }
}