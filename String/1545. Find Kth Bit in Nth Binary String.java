class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder s = new StringBuilder("0");
        while(s.length() < k){
            String temp = s.toString();
            s.append("1");
            for(int i = temp.length()-1;i>=0 && s.length() < k;i--){
                char c = temp.charAt(i) == '1' ? '0' : '1';
                s.append(c);
            }
        }
        
        return s.charAt(k-1);
    }
}