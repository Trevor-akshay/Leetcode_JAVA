class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        
        int startFrom = chars.length;
        for(int i = chars.length - 1;i>0;i--){
            if(chars[i] < chars[i - 1]){
                startFrom = i;
                chars[i - 1]--;
            }
        }
        while(startFrom < chars.length){
            chars[startFrom++] = '9';
        }
                
        return Integer.parseInt(String.valueOf(chars));
    }
}