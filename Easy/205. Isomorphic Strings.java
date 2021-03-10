class Solution {
    public boolean isIsomorphic(String s, String t) {
      HashMap<Character, Character> dict = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(!dict.containsKey(s.charAt(i))){
                if(dict.containsValue(t.charAt(i))) 
                    return false;
               dict.put(s.charAt(i), t.charAt(i)); 
            } 
            else{
                if(dict.get(s.charAt(i)) != t.charAt(i)) 
                    return false;
            }
        }
        return true;
    }
}