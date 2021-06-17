class CombinationIterator {
    List<String> lists;
    int index = 0;
    public CombinationIterator(String characters, int combinationLength) {
        lists = new ArrayList<>();
        combination(new StringBuilder(),characters,new boolean[characters.length()],0,combinationLength);
    }
    
    private void combination(StringBuilder s,String a,boolean[] visited,int pos,int size){
        if(s.length() == size){
            lists.add(s.toString());
            return;
        }
        for(int i = pos;i<a.length();i++){
            if(!visited[i]){
                visited[i] = true;
                s.append(a.charAt(i));
                combination(s,a,visited,i,size);
                s.deleteCharAt(s.length()-1);
                visited[i] = false;
            }
        }
    }
    
    public String next() {
        if(index == lists.size())
            return "";
        return lists.get(index++);
    }
    
    public boolean hasNext() {
        return index != lists.size();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */