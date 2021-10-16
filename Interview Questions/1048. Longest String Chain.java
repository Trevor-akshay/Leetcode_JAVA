class Solution {
    public int longestStrChain(String[] words) {
        if(words.length == 0 || words == null)
            return 0;
        Set<String> set = new HashSet<>();
        Arrays.stream(words).forEach(set::add);
        Map<String,Integer> memo = new HashMap<>();
        
        int max = 1;
        for(var word : words)
            max = Math.max(max,helper(word,memo,set));
        
        return max;
    }

    private int helper(String s,Map<String,Integer> memo,Set<String> set){
        if(memo.containsKey(s))
            return memo.get(s);
        
        int count = 0;
        for(int i = 0;i<s.length();i++){
            String temp = s.substring(0,i) + s.substring(i + 1);
            if(set.contains(temp)){
                count = Math.max(count,helper(temp,memo,set));
            }
        }
        
        memo.put(s,count + 1);
        return memo.get(s);
    }
}