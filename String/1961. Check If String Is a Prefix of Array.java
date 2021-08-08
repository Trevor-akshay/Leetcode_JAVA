class Solution {
    public boolean isPrefixString(String s, String[] words) {
        int i = 0;
        Outer : for(int j = 0;j<words.length && i < s.length();j++){
            var word = words[j];
            for(char c : word.toCharArray()){
                if(i == s.length() || c != s.charAt(i))
                    return false;
                i++;
            }
        }
        return i == s.length();
    }
}