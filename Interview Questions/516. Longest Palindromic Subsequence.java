class Solution {
    public int longestPalindromeSubseq(String s) {
        Integer[][] memo = new Integer[s.length()][s.length()];
        return helper(0,s.length()-1,s,memo);
    }
    
    private int helper(int i,int j,String s,Integer[][] memo){
        if(i == j)
            return 1;
        else if(i > j)
            return 0;
        
        if(memo[i][j] == null){
            if(s.charAt(i) == s.charAt(j))
                return helper(i + 1,j - 1,s,memo) + 2;
        
            int p1 = helper(i + 1,j,s,memo);
            int p2 = helper(i,j-1,s,memo);
            memo[i][j] = Math.max(p1,p2);
        }
        return memo[i][j];
    }
}