class Solution {
    public int minDistance(String word1, String word2) {
        Integer[][] memo = new Integer[word1.length()][word2.length()];
        return helper(0,0,word1,word2,memo);
    }
    
    private int helper(int i,int j,String word1,String word2,Integer[][] memo){
        if(j == word2.length())
            return word1.length() - i;        
        if(i == word1.length())
            return word2.length() - j;
        
        if(memo[i][j] == null){
            if(word1.charAt(i) == word2.charAt(j))
                return helper(i + 1,j + 1,word1,word2,memo);
        
            int insert = 1 + helper(i + 1,j,word1,word2,memo);
            int delete = 1 + helper(i,j + 1,word1,word2,memo);
            int replace = 1 + helper(i + 1,j + 1,word1,word2,memo);
            memo[i][j] = Math.min(insert,Math.min(delete,replace));
        }
        
        return memo[i][j];
    }
}