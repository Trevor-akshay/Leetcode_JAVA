class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int positiveMaxSum = kadane(nums,true);
        int negativeMaxSum = kadane(nums,false);
        
        return Math.max(positiveMaxSum,negativeMaxSum);
    }
    
    private int kadane(int[] nums,boolean positive){
        int max = nums[0];
        int maxHere = nums[0];
        if(positive)
            nums[0] *= -1;
        
        for(int i = 1;i<nums.length;i++){
            maxHere = Math.max(maxHere + nums[i],nums[i]);
            max = Math.max(maxHere,max);
            
            if(positive)
                nums[i] *= -1;
        }
        return max;
    }
}