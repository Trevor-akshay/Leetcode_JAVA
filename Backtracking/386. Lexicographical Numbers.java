class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> l = new ArrayList<>();
        for(int i = 1;i<10;i++){
            if(i <= n)
                dfs(i,n,l);
        }
        
        return l;
    }
    
    private void dfs(int value,int max,List<Integer> list){
        list.add(value);
        for(int i = 0;i<10;i++){
            int temp = value * 10 + i;
            if(temp > max)
                return;
            dfs(temp,max,list);
        }
    }
}