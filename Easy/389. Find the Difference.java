class Solution {
    public char findTheDifference(String s, String t) {
         int tNum = getCount(t);
        int sNum = getCount(s);
        return (char) (tNum-sNum);
    }
    
    private int getCount(String s) {
        int sNum = 0;
         for(int i=0; i<s.length(); i++) {
            sNum = sNum + s.charAt(i);
        }
        return sNum;
    }
}