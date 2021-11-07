class Solution {
    public long countVowels(String s) {
        long res = 0;
        int n = s.length();
        for(int i = 0;i<n;i++){
            char c = s.charAt(i);
            
            if(isVowel(c)){
                res += (long)(i + 1) * (long)(n - i);
            }
        }
        
        return res;
    }
    
    private boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' 
               || c == 'o' || c == 'u';
    }
}