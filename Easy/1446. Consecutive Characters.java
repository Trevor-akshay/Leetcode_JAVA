class Solution {
    public int maxPower(String s) {
        int length = 1;
        int temp = 1;
        char c = s.charAt(0);
        for(int i = 1;i<s.length();i++){
            char c1 = s.charAt(i);
            if(c1 != c){
                length = Math.max(length,temp);
                temp = 0;
                c = c1;
            }
            temp++;
        }
        return Math.max(length,temp);
        }
}