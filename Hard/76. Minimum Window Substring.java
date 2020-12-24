class Solution {
    public String minWindow(String s, String t) {
        if(t==null || t.isEmpty() || t.length()>s.length())
            return "";
        HashMap<Character, Integer> tMap = new HashMap<>();
        for(char c : t.toCharArray())
            tMap.put(c,tMap.getOrDefault(c,0)+1);

        int rightIndex = 0;
        int leftIndex = 0;
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int charsIncluded = 0;
        for (int right = 0; right < s.length(); right++) {

            if (tMap.containsKey(s.charAt(right))) {
                tMap.put(s.charAt(right), tMap.get(s.charAt(right)) - 1);
                if (tMap.get(s.charAt(right)) >= 0)
                    charsIncluded++;
            }
            while (charsIncluded == t.length()) {
                if (minLength > (right - left + 1)) {
                    minLength = right - left + 1;
                    rightIndex = right;
                    leftIndex = left;
                }
                char leftChar = s.charAt(left++);
                if (tMap.containsKey(leftChar)) {
                    if (tMap.get(leftChar) == 0)
                        charsIncluded--;
                    tMap.put(leftChar, tMap.get(leftChar) + 1);
                }
            }

        }

        return minLength==Integer.MAX_VALUE?"":s.substring(leftIndex, rightIndex + 1);
    }
}