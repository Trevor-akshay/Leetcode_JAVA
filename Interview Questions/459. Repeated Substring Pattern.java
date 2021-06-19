class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int[] lps = new int[s.length()];
        int i = 1;
        for(int j = 0; i < s.length();) {//
            if(s.charAt(i) == s.charAt(j)) {
                lps[i] = j+1;
                i++;
                j++;
            }
            else if(j!=0 && s.charAt(i) != s.charAt(j)) {
                j = lps[j-1];
            }
            else {
                i++;
            }
        }
        return lps[lps.length -1] != 0 && 
               s.length() % ( s.length() - lps[lps.length - 1]) == 0;
    }
}

