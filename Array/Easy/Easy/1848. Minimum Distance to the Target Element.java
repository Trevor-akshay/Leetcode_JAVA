class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int i = start;
        int j = start;
        while(i >= 0 || j < nums.length){
            if(i>= 0 && nums[i] == target)
                return start - i;
            else if(j < nums.length && nums[j] == target)
                return j - start;
            i--;
            j++;
        }
        
        return 0;
    }
}