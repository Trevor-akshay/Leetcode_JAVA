class Solution {
    public String toGoatLatin(String S) {
        StringBuilder res = new StringBuilder();
        StringBuilder a = new StringBuilder("ma");
        for(String word : S.split(" ")){
            StringBuilder temp = new StringBuilder(word);
            a = a.append("a");
            if(isVowel(temp.charAt(0))){
                res.append(temp).append(a).append(" ");
            }else{
                char c = temp.charAt(0);
                temp.deleteCharAt(0);
                res.append(temp).append(c).append(a).append(" ");
            }
        }
        
        return res.deleteCharAt(res.length()-1).toString();
    }
    
    
    private boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || 
           c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' )
            return true;
        
        return false;
        
    }
}