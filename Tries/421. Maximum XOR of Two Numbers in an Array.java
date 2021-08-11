class Solution {
    class Trie{
        Trie[] children = new Trie[2];
    }
        //[0] = 0 bit  && [1] = 1 bit
    
    public int findMaximumXOR(int[] nums) {
        Trie root = new Trie();
        for(var num : nums)
            insert(root,num);
        
        int max = 0;
        for(var num : nums){
            var cur = root;
            int tempMax = 0;
            for(int i = 30;i>=0;i--){
                int bit = (num & (1 << i)) > 0 ? 1 : 0;
                if(cur.children[bit ^ 1] != null){
                    cur = cur.children[bit ^ 1];
                    tempMax += (1 << i);
                }else{
                    cur = cur.children[bit];
                }
            }
            max = Math.max(max,tempMax);
        }
        return max;
    }
    
    private void insert(Trie root,int value){
            var cur = root;
            for(int i = 30;i>=0;i--){
                int bit = (value & (1 << i)) > 0 ? 1 : 0;
                if(cur.children[bit] == null)
                    cur.children[bit] = new Trie();
                
                cur = cur.children[bit];
            }
        }
    }
