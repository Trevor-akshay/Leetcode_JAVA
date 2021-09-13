class Solution {
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new Boolean[s.length()];
        Set<String> set = new HashSet<>(wordDict);
        return helper(0,s,set);
    }
    
    private boolean helper(int index,String s,Set<String> set){
        if(s.length() == index)
            return true;
        if(memo[index] != null)
            return memo[index];
        
        for(int i = index;i<=s.length();i++){
            String temp = s.substring(index,i);
            if(set.contains(temp) && helper(i,s,set))
                return memo[index] = true;
        }
        return memo[index] = false;
    }
}