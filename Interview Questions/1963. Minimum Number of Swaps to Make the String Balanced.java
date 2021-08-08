class Solution {
    public int minSwaps(String s) {
        int brackets = 0;
        for(char c : s.toCharArray()){
            if(c == '[')
                brackets++;
            else if(brackets > 0)
                brackets--;
        }
        
        return (brackets + 1) / 2;
    }
}