class Solution {
    public int minSteps(String s, String t) {
        int[] sFreq = new int[26];
        int[] tFreq = new int[26];

        for(int i = 0;i<s.length();i++){
            sFreq[s.charAt(i) - 'a']++;
            tFreq[t.charAt(i) - 'a']++;
        }
        
        
        int max = 0;
        for(int i = 0;i<26;i++){
            if(tFreq[i] < sFreq[i])
                max += sFreq[i] - tFreq[i];
        }

        return max;
    }
}