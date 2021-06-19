class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] sArray = new int[26];
        for(char c : s.toCharArray())
            sArray[c-'a']++;
        int[] tArray =new int[26];
        for(char c:t.toCharArray())
            tArray[c-'a']++;
        return Arrays.equals(tArray,sArray);
    }
}