class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        
        if (nums == null || nums.length == 0) return res;
        
        int i=0; 
        while (i < nums.length) {
            int s = i;
            while (i < nums.length-1 && nums[i] + 1 == nums[i+1]) i++;
            if (i == s){
                res.add(String.valueOf(nums[i]));
            } else {
                res.add(String.valueOf(nums[s] + "->" + nums[i]));
            }
            i++;
        }
        
        return res;
    }
}