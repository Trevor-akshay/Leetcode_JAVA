class Solution {
    public int balancedStringSplit(String s) {
        
    Map<Character,Integer> map = new HashMap<>();
        map.put('R',0);map.put('L',0);

        int split = 0;
        for(char c : s.toCharArray()){
            if(map.get('R').equals(map.get('L'))){
                split++;
                map.put('R',0);map.put('L',0);
            }
            if(c == 'R')
                map.put('R',map.getOrDefault('R',0)+1);
            else
                map.put('L',map.getOrDefault('L',0)+1);
        }
        
        return split;
    }
}