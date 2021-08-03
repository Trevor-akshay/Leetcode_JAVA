class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int prev = -1;
        for(int i = nums.length-1;i>=0;i--){
            int temp = 1;
            if(prev == nums[i])
                continue;
            int chance = k;
            for(int j = i-1;j>=0;j--){
                chance -= nums[i] - nums[j];
                if(chance < 0)
                    break;
                temp++;
            }
            count = Math.max(count,temp);
            prev = nums[i];
        }
        
        return count;
    }
}