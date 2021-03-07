class Solution {
    public int minElements(int[] nums, int limit, int goal) {
      
    long sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
        }
        long diff = 0;
        if(sum > goal) {
            diff = sum - goal;
        }else diff = goal - sum;
        if((sum - goal) % limit == 0) return (int) (diff / limit);
        return (int) (diff / limit + 1);
    }
}