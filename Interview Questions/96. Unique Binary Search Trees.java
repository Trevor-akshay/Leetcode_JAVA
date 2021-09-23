class Solution {
    public int numTrees(int n) {
        Integer[] memo = new Integer[n + 1];
        return helper(n,memo);
    }
    
    private int helper(int n,Integer[] memo){
        if(n == 0 || n == 1)
            return 1;
        
        if(memo[n] == null){
            int count = 0;
            for(int i = 1;i<=n;i++){
                int leftCount = helper(i - 1,memo);
                int rightCount = helper(n - i,memo);
                count += leftCount * rightCount;
            }
            memo[n] = count;
        }
        
        return memo[n];
    }
}