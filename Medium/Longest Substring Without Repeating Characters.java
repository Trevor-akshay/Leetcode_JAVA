class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)return 0;
        if(s.length() == 1)return 1; //"aabaab!bb"
        int maxLength =0;
        Map<Character,Integer> map = new HashMap<>();
        int left= 0,right = 0;
        while(right<s.length()){
            if(!map.containsKey(s.charAt(right)))
                map.put(s.charAt(right),1);
            else{
                while (s.charAt(left) != s.charAt(right)){
                    map.remove(s.charAt(left++));
                }
                left++;
            }
           // System.out.println(map);
            maxLength = Math.max(maxLength,map.size());
            right++;
        }
        return maxLength;
    }
}