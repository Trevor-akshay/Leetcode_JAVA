class Solution {
    public int threeSumClosest(int[] nums, int target) {
      if(nums.length == 3) return Arrays.stream(nums).sum();
            Arrays.sort(nums);
            int sum = Integer.MAX_VALUE;
            for(int i = 0;i<nums.length;i++) {
                    int j = i + 1,k=nums.length-1;
                while(j<k){
                    int value = nums[i] + nums[j] + nums[k];
                    if (value == target) return value;
                   if(Math.abs(sum) > Math.abs(target - value))
                   sum = target-value;
                    else if(value <target )j++;
                    else    k--;
                }
            }
            
            return target-sum;
    }
}