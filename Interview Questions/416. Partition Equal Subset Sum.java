//DP
class Solution {
    public boolean canPartition(int[] elements) {
        int sum = Arrays.stream(elements).sum();
        if((sum & 1) == 1)
            return false;
        int capacity = sum / 2;
        boolean[][] dp = new boolean[elements.length][capacity + 1];
        for(int row = 0;row<dp.length;row++)
            dp[row][0] = true;
        for(int col = 1;col<dp[0].length;col++)
            dp[0][col] = elements[0] == col;    

        for(int i = 1;i<dp.length;i++){
            for(int j = 1;j<dp[0].length;j++){
                if(j < elements[i])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - elements[i]];
            }
        }    

        return dp[dp.length-1][dp[0].length-1];     
    }
}


//MEMO

class Solution {
    public boolean canPartition(int[] elements) {
        int sum = Arrays.stream(elements).sum();
        if((sum & 1) == 1)
            return false;
        int capacity = sum / 2;
        int[][] memo = new int[elements.length][capacity + 1];

        return helper(0,memo,elements,capacity) == 1;
    }

    private static int helper(int index,int[][] memo,int[] elements,int capacity){
       if(capacity == 0)
            return 1;  
        else if(index == elements.length || capacity < 0)
            return -1;    
        else if(memo[index][capacity] != 0)
            return memo[index][capacity];  
        memo[index][capacity] = Math.max(helper(index + 1,memo,elements,capacity - elements[index]),
                                helper(index + 1,memo, elements, capacity));

        return memo[index][capacity];              
    }
    }
