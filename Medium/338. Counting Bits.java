class Solution {
    public int[] countBits(int num) {
         int[] ans = new int[num + 1];
         ans[0] = 0;
        
        for(int i = 1; i < ans.length; i++) 
            
            ans[i] = ans[(i & (i - 1))] + 1;
            
        
        return ans;
    }
}