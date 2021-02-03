class WordDictionary {

    Map<Integer, Set<String>> map;
    public WordDictionary() {
        map = new HashMap<>();
    }

    public void addWord(String word) {
        map.computeIfAbsent(word.length(),string -> new HashSet<>()).add(word);
    }
    public boolean search(String word) {
        if(!map.containsKey(word.length()))
             return false;
        for(var str : map.get(word.length())){
            int i = 0;
            while (i<word.length() && (str.charAt(i) == word.charAt(i) || word.charAt(i) == '.'))
                i++;
            if(i == word.length())
                 return true;
        }
        return false;
    }

}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */