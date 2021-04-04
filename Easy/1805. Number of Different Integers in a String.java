class Solution {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        for(int i =0;i<word.length();i++){
            if(Character.isDigit(word.charAt(i))){
                StringBuilder s = new StringBuilder();
                while(i<word.length() && Character.isDigit(word.charAt(i))){
                    if(s.length() == 0 && word.charAt(i) == '0'){}
                    else
                        s.append(word.charAt(i));
                    i++;
                }
                
                set.add(s.toString());
            }
        }
        
        return set.size();
    }
}