class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int length = 0;
        int left = 0;
        int currentCost = 0;
        for(int right = 0; right < s.length(); right=right+1){
            currentCost += Math.abs(s.charAt(right) - t.charAt(right));
            while(left <= right && currentCost > maxCost){
                currentCost -= Math.abs(s.charAt(left) - t.charAt(left));
                left=left+1;
            }
            length = Math.max(length, right-left+1);
        }
        return length;
    }
}