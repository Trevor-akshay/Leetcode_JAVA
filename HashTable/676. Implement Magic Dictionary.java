class MagicDictionary {

    /** Initialize your data structure here. */
    Map<Integer,Set<String>> map;
    public MagicDictionary() {
        map = new HashMap<>();
    }
    
    public void buildDict(String[] d) {
        //int index = 0;
        for(var word : d){
            map.putIfAbsent(word.length(),new HashSet());
            map.get(word.length()).add(word);
        }
           
    }
    
    public boolean search(String searchWord) {
        if(!map.containsKey(searchWord.length()))
            return false;
        Set<String> set = map.get(searchWord.length());
        for(var word : set){
            int count = 0;
            for(int i = 0;i<word.length();i++){
               count = word.charAt(i) != searchWord.charAt(i) ? count+1 : count;
            }
            if(count == 1)
                    return true;
        }   
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */