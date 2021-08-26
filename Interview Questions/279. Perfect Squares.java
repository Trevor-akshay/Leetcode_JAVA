class Solution {
    public int numSquares(int n) {
        Integer[] memo = new Integer[n + 1];
        return helper(n,memo);
    }
    
    private int helper(int n,Integer[] memo){
        if(n == 0)
            return 0;
        if(memo[n] != null)
            return memo[n];
        int min = 1000;
        for(int i = 1;i*i<=n;i++){
            min = Math.min(min,1 + helper(n - (i*i),memo));
        }
        memo[n] = min;
        return memo[n];
    }
}


class Solution {
    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        int i = 1;
        while(true){
            int val = i*i;
            if(val == n)
                return 1;
            else if(val > n)
                break;
            list.add(val);
            i++;
        }
        Integer[] memo = new Integer[n + 1];
        return helper(0,list,n,memo);
    }
    
    private int helper(int index,List<Integer> list,int n,Integer[] memo){
        if(n == 0)
            return 0;
        if(n < 0 || index == list.size())
            return 1000;
        if(memo[n] != null)
            return memo[n];
        int included = 1 + helper(index,list,n - list.get(index),memo);
        int excluded = helper(index + 1,list,n,memo);
        
        memo[n] = Math.min(included,excluded);
        return memo[n];
    }
}