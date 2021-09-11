class Solution {
    String max = "";
    public String longestPalindrome(String s) {
        String[][] memo = new String[s.length()][s.length()];
        return helper(0,s.length()-1,s,memo);
    }
    
    private String helper(int i,int j,String s,String[][] memo){
        if(i == j)
            return s.substring(i,j+1);
        else if(memo[i][j] != null)
            return memo[i][j];
        if(isPalindrome(s,i,j)){
            max = s.substring(i,j+1);
        }else{
            String c1 = helper(i + 1,j,s,memo);
            String c2 = helper(i,j-1,s,memo);
            if(c1.length() > c2.length())
                max = c1;
            else
                max = c2;
            
        }
        
        return memo[i][j] = max;
        
    }
    
    private boolean isPalindrome(String s,int i,int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;j--;
        }
        
        return true;
    }
}