class MapSum {

    /** Initialize your data structure here. */
   class TrieNode{
    TrieNode[] children;
    int val;
    public TrieNode(){
        children = new TrieNode[26];
        val=0;
    }
}
    TrieNode root;
    HashMap<String,Integer> words;
    public MapSum() {
        root = new TrieNode();
        words = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        TrieNode node = root;
        int add = 0;
        if(words.containsKey(key)){
            add = val-words.get(key);
        }
        else{
            add = val;
        }
        words.put(key,val);
        for(char c : key.toCharArray()){
            if(node.children[c-'a'] == null){
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
            node.val+=add;
        }
    }
    
    public int sum(String prefix) {
        TrieNode node = root;
        for(char c : prefix.toCharArray()){
            if(node.children[c-'a'] == null) return 0;
            node = node.children[c-'a'];
        }
        return node.val;
}
}


/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */