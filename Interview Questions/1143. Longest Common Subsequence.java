class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        
        for(int row = 1;row <= s1.length();row++){
            for(int col = 1;col <= s2.length();col++){
                if(s1.charAt(row-1) != s2.charAt(col-1))
                    dp[row][col] = Math.max(dp[row-1][col],dp[row][col-1]);
                else
                    dp[row][col] = dp[row-1][col-1] + 1;    
            }
        } 
        
        return dp[dp.length-1][dp[0].length-1];
    }
}

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] memo = new Integer[text1.length()][text2.length()];
        return helper(0,0,text1,text2,memo);
    }
    
    private int helper(int index1,int index2,String s1,String s2,Integer[][] memo){
        if(index1 == s1.length() || index2 == s2.length())
            return 0;
            
        if(memo[index1][index2] == null){    
            if(s1.charAt(index1) == s2.charAt(index2))    
                return 1 + helper(index1 + 1,index2+1,s1,s2,memo);
            int p1 = helper(index1 + 1,index2,s1,s2,memo );
            int p2 = helper(index1,index2 + 1,s1,s2,memo);    

            memo[index1][index2] = Math.max(p1, p2);
        }
        return memo[index1][index2];
    }
}