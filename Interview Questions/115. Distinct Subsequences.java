class Solution {
    public int numDistinct(String s, String t) {
        if(t.length() > s.length())
            return 0;
        Integer[][] memo = new Integer[s.length()][t.length()];
        return helper(0,0,s,t,memo);
    }
    
    private int helper(int i,int j,String s,String t,Integer[][] memo){
        if(j == t.length())
            return 1;
        else if(i == s.length())
            return 0;
        if(memo[i][j] == null){
            int c1 = 0;
            if(s.charAt(i) == t.charAt(j))
                c1 = helper(i + 1,j + 1,s,t,memo);
            int c2 = helper(i + 1,j,s,t,memo);
                memo[i][j] = c1 + c2;
        }
        return memo[i][j];
    }
}