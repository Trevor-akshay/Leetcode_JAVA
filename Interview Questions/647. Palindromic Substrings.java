class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] memo = new boolean[len][len];
        helper(0,s.length()-1,s,memo);
        return count + s.length();
    }
    
    private void helper(int i,int j,String s,boolean[][] memo){
        if(i == j){
            return;
        }
        else if(memo[i][j])
            return;
        
        if(isPal(s,i,j))
            count++;
        
        helper(i + 1,j,s,memo);
        helper(i,j-1,s,memo);
        memo[i][j] = true;
    }
    
    private boolean isPal(String s,int i,int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }    
        
        return true;
    }
}