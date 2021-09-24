class Solution {
    Boolean[][] memo;
    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length()][p.length()];
        return helper(s,p,s.length()-1,p.length()-1);
    }
    
    private boolean helper(String s,String p,int i,int j){
        if(j < 0 && i < 0)
            return true;
        if(j < 0 || (i < 0 && p.charAt(j) != '*'))
            return false;
        if(i < 0 && p.charAt(j) == '*')
            return helper(s,p,i,j - 1);
        
        if(memo[i][j] == null){
            if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
                return helper(s,p,i - 1,j - 1);
            else if(p.charAt(j) == '*'){
                boolean result = false;
                result = helper(s,p,i,j - 1);    
                if(!result)
                    result |= helper(s,p,i - 1,j);
            
            return memo[i][j] = result;
            }
        }
        
        return memo[i][j] = false;
    }
}