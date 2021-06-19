class Solution {
    public int strStr(String haystack, String needle) {
       if(needle.length() > haystack.length()) return -1;
        if(needle.length() == 0) return 0;
        int left = 0,right=0;
        int index = -1;
        StringBuilder stringBuilder = new StringBuilder();
        while (right<needle.length())
            stringBuilder.append(haystack.charAt(right++));
        if(stringBuilder.toString().equals(needle))
            return left;
        while(right<haystack.length()){
            stringBuilder.deleteCharAt(0);
            left++;
            stringBuilder.append(haystack.charAt(right));
            if(stringBuilder.toString().equals(needle)){
                index = left;
                break;
            }
            right++;
        }
        return index;
    }
}