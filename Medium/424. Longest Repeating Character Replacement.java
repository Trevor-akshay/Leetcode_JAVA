class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, maxLength = 0, repeatFrequency = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(right = 0; right < s.length(); right++)
        {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right) , 0)+1);
            repeatFrequency = Math.max(repeatFrequency, map.get(s.charAt(right)));

            if(right-left+1-repeatFrequency > k)
            {
                map.put(s.charAt(left),map.getOrDefault(s.charAt(left),
                        0)-1);
                left++;
            }

            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }
}