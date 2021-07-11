class Solution {
    int max = 0;
    public int maxUniqueSplit(String s) {
        dfs(s,new HashSet<>(),0);
        
        return max;
    }
    
    private void dfs(String s,Set<String> visited,int index){
        if(index > s.length()-1){
            max = Math.max(visited.size(),max);
            return;
        }
        for(int i = index;i<s.length();i++){
            String temp = s.substring(index,i+1);
            if(visited.add(temp)){
                dfs(s,visited,i+1);
                visited.remove(temp);
            }
        }
    }
}