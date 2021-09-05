class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        Integer[] memo = new Integer[arr.length];
        
        return helper(0,arr,k,memo);
    }
    
    private int helper(int index,int[] arr,int k,Integer[] memo){
        if(index == arr.length)
            return 0;
        
        else if(memo[index] != null)
            return memo[index];
        
        int maxElement = 0;
        int maxSum = 0;
        
        for(int i = index;i<Math.min(index + k,arr.length);i++){
            maxElement = Math.max(maxElement,arr[i]);
            maxSum = Math.max(maxSum,
                              maxElement * (i - index + 1) +helper(i + 1,arr,k,memo));
        }
        
        return memo[index] = maxSum;
    }
}