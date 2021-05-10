class Solution {
    public int countHomogenous(String s) {
        long count = 0;
        long left = 0,right = 0;

        while (right < s.length()){
            while (right < s.length() && s.charAt((int)right) == s.charAt((int)left)){
                right++;
            }
            
            long size  = right - left ;
            count += ((size) * (size + 1)) / 2 % 1000000007;
            left = right;
        }
        return (int)count;
    }
}
