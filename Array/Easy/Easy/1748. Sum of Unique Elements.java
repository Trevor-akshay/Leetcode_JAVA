class Solution {
    public int sumOfUnique(int[] nums) {
         var uniqueCount = new int[101];
        var sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (uniqueCount[nums[i]]++ == 0)    
                sum += nums[i];
            else if (uniqueCount[nums[i]] == 2) 
                sum -= nums[i];
        }
        return sum;
    }
}