class Solution {
    public int minCostClimbingStairs(int[] cost) {
         int n = cost.length;
        int c1 = 0;
        int c2 = 0;
        
        for (int i=1; i<=n; i++) {
            int temp = Math.min(c1, c2) + cost[i-1];
            c2 = c1;
            c1 = temp;
        }
        
        return Math.min(c1, c2);
    }
}