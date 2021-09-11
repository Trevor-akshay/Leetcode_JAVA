class Solution {
    public int minInsertions(String s) {
        int len = s.length();
        Integer[][] memo = new Integer[len][len];
        return len - helper(0,len-1,s,memo);
    }
    
    private int helper(int i,int j,String s,Integer[][] memo){
        if(i == j)
            return 1;
        else if(i > j)
            return 0;
        
        if(memo[i][j] == null){
            if(s.charAt(i) == s.charAt(j))
                return 2 + helper(i + 1,j - 1,s,memo);
            int c1 = helper(i + 1,j,s,memo);
            int c2 = helper(i,j- 1,s,memo);
            memo[i][j] = Math.max(c1,c2);
        }
        return memo[i][j];
    }       
}