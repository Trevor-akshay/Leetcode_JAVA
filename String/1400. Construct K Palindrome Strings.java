class Solution {
    public boolean canConstruct(String s, int k) {
        if(k > s.length())
            return false;
        int[] freq = new int[26];
        for(char c : s.toCharArray())
            freq[c - 'a']++;
        
        int oddCounts = 0;
        for(var f : freq)
            oddCounts += f % 2 == 1 ? 1 : 0;
        if(oddCounts > k)
            return false;
        return true;
    }
}