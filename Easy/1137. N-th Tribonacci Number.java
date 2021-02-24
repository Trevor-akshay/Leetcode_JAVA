class Solution {
    int[] memo;
    Solution(){
        memo = new int[38];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 1;
    }
    public int tribonacci(int n) {
        if(n == 0 || memo[n] != 0)
            return memo[n];
        else{
            int ans =  tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
            memo[n] = ans;
            return ans;

        }
    }
}