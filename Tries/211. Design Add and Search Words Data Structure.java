class WordDictionary {
    class TrieNode{
        char value;
        TrieNode[] children = new TrieNode[26];
        boolean isLeaf;
        TrieNode(char value){
            this.value = value;
            isLeaf = false;
        }
    }
    /** Initialize your data structure here. */
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode(' ');
    }
    
    public void addWord(String word) {
        var cur = root;
        for(char c : word.toCharArray()){
            int index = c -'a';
            if(cur.children[index] == null)
                cur.children[index] = new TrieNode(c);
            cur  = cur.children[index];
        }
        cur.isLeaf = true;
    }
    
    public boolean search(String word) {
        return helper(word.toCharArray(),root,0);
    }
    
    private boolean helper(char[] word,TrieNode root,int pos){
        if(pos == word.length)
            return root.isLeaf;
        if(word[pos] == '.'){
            for(int i = 0;i<26;i++){
                if(root.children[i] != null && helper(word,root.children[i],pos+1))
                return true;
            }
        }else{
            return root.children[word[pos] - 'a'] != null && 
                helper(word,root.children[word[pos] - 'a'],pos+1);
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