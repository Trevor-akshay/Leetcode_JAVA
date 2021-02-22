class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        
    Set<Character> set = new HashSet<>();
        for(char c : allowed.toCharArray()){
            set.add(c);
        }
       int valid = 0;
        Outer : for(var word : words){
            for(char c : word.toCharArray()){
                if(!set.contains(c))
                    continue Outer;
            }
            valid++;
        }
        
        return valid;
    }
}