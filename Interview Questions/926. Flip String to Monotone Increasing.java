class Solution {
    public int minFlipsMonoIncr(String s) {
        int i = 0;
        while(i < s.length() && s.charAt(i) == '0')
            i++;
        
        int countZero = 0;
        int countOne = 0;
        while(i < s.length()){
            countZero += s.charAt(i) == '0' ? 1 : 0;
            countOne += s.charAt(i) == '1' ? 1 : 0;
            
            if(countZero > countOne)
                countZero = countOne;
            i++;
        }
        
        return countZero;
    }
}