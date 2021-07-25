class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] freq = new int[26];
        
        for(var c : s.toCharArray())
            freq[c - 'a']++;
        
        int prev = -1;
        for(int i = 0;i<26;i++){
            if(prev == -1 && freq[i] > 0)
                prev = freq[i];
            else if(freq[i] != 0 && prev != freq[i])
                return false;
        }
        
        return true;
    }
}