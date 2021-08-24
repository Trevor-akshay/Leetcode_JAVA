class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int capacity = Arrays.stream(nums).sum();
        if(capacity % k != 0)
            return false;
        return partitionHelper(0,nums,k,capacity / k,0);
    }
    private boolean partitionHelper(int index,int[] nums,int k,int target,int sum){
        if(k == 1)
            return true;
        else if(sum > target)
            return false;
        if(sum == target)
            return partitionHelper(0,nums,k - 1,target,0);
        
        for(int i = index ; i< nums.length;i++){
            int temp = nums[i];
            if(nums[i] != -1){
                nums[i] = -1;
                if(partitionHelper(i + 1,nums,k,target,sum + temp))
                    return true;
            }
            nums[i] = temp;
        }
        
        return false;
    }
}