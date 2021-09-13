class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        Map<String,Boolean> memo = new HashMap<>();
        return helper(0,0,0,s1,s2,s3,memo);
    }
    
    private boolean helper(int i,int j,int k,
                           String s1,String s2,String s3, Map<String,Boolean> memo){
                
        if(k == s3.length() && i == s1.length() && j == s2.length())
            return true;
        else if(k == s3.length())
            return false;
        
        String temp = i + "|" + j;
        if(memo.get(temp) == null){
            boolean c1 = false;
            boolean c2 = false;
            if(i < s1.length() && s3.charAt(k) == s1.charAt(i))
                c1 = helper(i + 1,j,k + 1,s1,s2,s3,memo);
            if(j < s2.length() && s3.charAt(k) == s2.charAt(j))
                c2 = helper(i,j + 1,k + 1,s1,s2,s3,memo);
            
            memo.put(temp,c1 || c2);
        }
        return memo.get(temp);
    }
}