class Solution {
    int max = 0;
    public int maxProduct(String s) {
        helper(0,"","",s);
        return max;
    }
    
    private void helper(int index,String p1,String p2,String s){
        if(isPal(p1) && isPal(p2))
            max = Math.max(p1.length() * p2.length(),max);
        
        if(index == s.length())
            return;
               
        helper(index + 1,p1 + s.charAt(index),p2,s);
        helper(index + 1,p1,p2 + s.charAt(index),s);
        helper(index + 1,p1,p2,s);
    }
    
    private boolean isPal(String s){
        int i = 0,j = s.length()-1;
        
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;j--;
        }
        
        return true;
    }
}