class Solution {
    public boolean isSubsequence(String s, String t) {
        int j = 0;
        for(int i = 0;i<t.length() && j<s.length();i++){
            char c = t.charAt(i);
            char cc= s.charAt(j);
            if(c == cc){
                j++;
            }
        }
        
        return j == s.length();
    }
       
}