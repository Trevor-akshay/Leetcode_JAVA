class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i = 1;i<nums.length;i++)
            prefixSum[i] = nums[i] + prefixSum[i-1];
        
        List<Integer> res = new ArrayList<>();
        int sum = nums[nums.length-1];
        res.add(sum);
        
        for(int i = nums.length-2;i>=0;i--){
            if(sum > prefixSum[i]){
                break;
            }
            sum += nums[i];
            res.add(nums[i]);
        }
        
        return res;
    }
}