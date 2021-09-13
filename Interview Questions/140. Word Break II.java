class Solution {
    List<String> list = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        helper(0,s,set,"");
        return list;
    }
    
     private void helper(int index,String s,Set<String> set,String temp){
        if(s.length() == index){
            list.add(temp.substring(0,temp.length()-1));
            return;
        }
       
        for(int i = index;i<=s.length();i++){
            String sub = s.substring(index,i);
            if(set.contains(sub))
                helper(i,s,set,temp + sub + " ");
        }
    }
}