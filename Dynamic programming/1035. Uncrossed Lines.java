class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        Integer[][] memo = new Integer[nums1.length][nums2.length];
        return helper(0,0,nums1,nums2,memo);
    }
    
    private int helper(int i,int j,int[] nums1,int[] nums2,Integer[][] memo){
        if(i == nums1.length || j == nums2.length)
            return 0;
        
        if(memo[i][j] == null){
            if(nums1[i] == nums2[j])
                return helper(i + 1,j + 1,nums1,nums2,memo) + 1;
        
            int c1 = helper(i + 1,j,nums1,nums2,memo);
            int c2 = helper(i,j + 1,nums1,nums2,memo);
            
            memo[i][j] = Math.max(c1,c2);
        }
        return memo[i][j];
    }
}