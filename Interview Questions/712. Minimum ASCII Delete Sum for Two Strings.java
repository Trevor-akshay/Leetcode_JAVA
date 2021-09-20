class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        Integer[][] memo = new Integer[s1.length()][s2.length()];
        
        return helper(0,0,s1,s2,memo);
    }
    
    private int helper(int i,int j,String s1,String s2,Integer[][] memo){
        if(i == s1.length() && j == s2.length())
            return 0;
        else if(i < s1.length() && j == s2.length()){
            int sum = 0;
            for(;i<s1.length();i++)
                sum += (int)s1.charAt(i);
            
            return sum;
        }else if(i == s1.length() && j < s2.length()){
            int sum = 0;
            for(;j<s2.length();j++)
                sum += (int)s2.charAt(j);
            
            return sum;
        }
        
        if(memo[i][j] == null){
            if(s1.charAt(i) == s2.charAt(j))
                return helper(i + 1,j + 1,s1,s2,memo);
            
            int c1 = helper(i + 1,j,s1,s2,memo) + (int)(s1.charAt(i));
            int c2 = helper(i,j + 1,s1,s2,memo) + (int)(s2.charAt(j));
            
            memo[i][j] = Math.min(c1,c2);
        }
        
        return memo[i][j];
    }
}