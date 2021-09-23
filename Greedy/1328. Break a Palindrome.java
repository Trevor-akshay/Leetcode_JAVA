class Solution {
    public String breakPalindrome(String p) {
        if(p.length() == 1)
            return "";
        
        char[] chars = p.toCharArray();
        int i = 0;
        while(i < p.length()){
            if(p.charAt(i) != 'a'){
                if(p.length() % 2 == 1 && i == p.length()/2){
                    i++;
                    continue;
                }
                chars[i] = 'a';
                return new String(chars);
            }
            i++;
        }
        chars[i-1] = 'b';
        return new String(chars);
    }
}