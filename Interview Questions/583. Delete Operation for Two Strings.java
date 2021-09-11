class Solution {
    public int minDistance(String word1, String word2) {
        int len = word1.length();
        int len2 = word2.length();
        Integer[][] memo = new Integer[len][len2];
        int tempLen =  helper(0,0,word1,word2,memo);
        return (len - tempLen) + (len2 - tempLen);
    }
    
    private int helper(int i,int j,String s1,String s2,Integer[][] memo){
        if(i == s1.length() || j == s2.length())
            return 0;
        
        if(memo[i][j] == null){
            if(s1.charAt(i) == s2.charAt(j))
                return 1 + helper(i + 1,j + 1,s1,s2,memo);
        
            int c1 = helper(i + 1,j,s1,s2,memo);
            int c2 = helper(i,j + 1,s1,s2,memo);
            memo[i][j] = Math.max(c1,c2);
        }
        
        return memo[i][j];
    }
}