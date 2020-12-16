class Solution {
    public int longestSubstring(String s, int k) {
        Map<Character,Integer> map = new HashMap();
        char[] str = s.toCharArray();
        for(char c: str){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        boolean valid = true;
        
        int start =0;
        int maxLen = 0;
        for(int end = 0;end<s.length();end++) {
            if(map.get(s.charAt(end)) > 0 && map.get(s.charAt(end)) < k){
                String subString = s.substring(start, end);
                maxLen  = Math.max(maxLen , longestSubstring(subString, k));
                start = end+1;
                valid = false;
            }
        }
        
        if(valid){
            return s.length();
        } else{
            return Math.max(maxLen, longestSubstring(s.substring(start), k));
        }
    }}


