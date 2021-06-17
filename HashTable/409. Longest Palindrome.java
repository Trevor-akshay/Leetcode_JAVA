class Solution {
    public int longestPalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int maxLength = 0;//"abccccdd"
        boolean odd = false;
        for(var key : map.keySet()){
            if(map.get(key) % 2 == 0)
                maxLength+=map.get(key);
            else{
                odd = true;
                maxLength+=map.get(key)-1;
            }
        }
        return odd ? maxLength+1 : maxLength;
    }
}