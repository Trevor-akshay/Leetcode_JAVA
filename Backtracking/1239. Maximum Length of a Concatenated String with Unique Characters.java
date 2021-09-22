class Solution {
    int length = 0;
    public int maxLength(List<String> arr) {
        dfs(0,arr,"");
        
        return length;
    }
    
    private void dfs(int index,List<String> A,String s){
        if(!uniqueChars(s))
            return;
        length = Math.max(length,s.length());
        for(int i = index;i<A.size();i++){
            dfs(i + 1,A,s + A.get(i));
        }
    }
    
    private boolean uniqueChars(String s){
        int[] chars = new int[26];
        for(char c : s.toCharArray()){
            if(chars[c - 'a'] == 1)
                return false;
            chars[c - 'a']++;
        }
           
        return true;
    }
}