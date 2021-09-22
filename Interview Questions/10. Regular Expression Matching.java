class Solution {
    public boolean isMatch(String s, String p) {
       return helper(s,p,s.length()-1,p.length()-1); 
    }
    
    private boolean helper(String s,String p,int sIndex,int pIndex){
       if(pIndex < 0 && sIndex < 0)
           return true;
        if(pIndex < 0 || (sIndex < 0 && p.charAt(pIndex) != '*'))
            return false;
        if(sIndex < 0 && p.charAt(pIndex) == '*')
            return helper(s,p,sIndex,pIndex - 2);
        
        if(s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.' )
            return helper(s,p,sIndex - 1,pIndex - 1);
        else if(p.charAt(pIndex) == '*'){
            boolean result = false;
            if(s.charAt(sIndex) == p.charAt(pIndex - 1) || 
                   p.charAt(pIndex - 1) == '.')
                result = helper(s,p,sIndex - 1,pIndex);
            
            if(!result){
                result |= helper(s,p,sIndex,pIndex - 2);
            }
            
            return result;
        }
        return false;
    }
}