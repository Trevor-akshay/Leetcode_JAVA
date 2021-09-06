class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        return Math.max(helper(0,0,nums,new Integer[n][n],true),
                       helper(0,0,nums,new Integer[n][n],false));
}
    
    private int helper(int index,int previousIndex,int[] nums,Integer[][] memo,boolean isAsc){
        if(index == nums.length)
            return 0;
        else if(memo[index][previousIndex] != null)
            return memo[index][previousIndex];
        int included = 0;
        if(isAsc){
            if(index == 0 || nums[previousIndex] > nums[index])
                included = helper(index + 1,index,nums,memo,!isAsc) + 1;
        }else{
            if(index == 0 || nums[previousIndex] < nums[index])
                included = helper(index + 1,index,nums,memo,!isAsc) + 1;
        }
        int excluded = helper(index + 1,previousIndex,nums,memo,isAsc);
        
        return memo[index][previousIndex] = Math.max(included,excluded);
    }
}
    
    