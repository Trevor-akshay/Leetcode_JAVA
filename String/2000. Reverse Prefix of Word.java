class Solution {
    public String reversePrefix(String word, char ch) {
        int index = find(word,ch);
        
        if(index == -1)
            return word;
        
        
        return rev(word,0,index);
    }
    
    private int find(String s,char c){
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == c)
                return i;
        }
        
        return -1;
    }
    
    private String rev(String s,int i,int j){
        var chars = s.toCharArray();
        while(i < j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;j--;
        }
        
        return new String(chars);
    }
}