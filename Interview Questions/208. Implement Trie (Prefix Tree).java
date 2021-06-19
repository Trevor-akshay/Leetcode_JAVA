class Trie {
    private class Node{
         Node[] children = new Node[26];
         boolean isLeaf;
         char value;
         Node(char value){
            this.value = value;
            isLeaf = false;
         }
    }
    /** Initialize your data structure here. */
    Node root; 
    public Trie() {
           root = new Node(' ');

    }
    /** Inserts a word into the trie. */
    public void insert(String word) {
        var curr = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(curr.children[index] == null)
                curr.children[index] = new Node(c);
            curr = curr.children[index];
        }
        curr.isLeaf = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        var curr = root;
        for(char c : word.toCharArray()){
            int index = c -'a';
            if(curr.children[index] == null)
                return false;
            curr = curr.children[index];
        }
        return curr.isLeaf;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        var curr = root;
        for(char c : prefix.toCharArray()){
            int index = c - 'a';
            if(curr.children[index] == null)
                return false;
            curr = curr.children[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */