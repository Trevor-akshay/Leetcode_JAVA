class Solution {
    public int maxHeight(int[][] A) {
        for(var a : A)// sort to make the height largest.
            Arrays.sort(a);
        
        //Apply LIS
        Arrays.sort(A, (a, b) -> (a[0] + a[1] + a[2]) - (b[0] + b[1] + b[2]));
        int[] dp = new int[A.length];
        int max = 0;
        
        for(int i = 0;i<A.length;i++){
            //if none can be placed on other
            dp[i] = A[i][2];
            max = Math.max(max,dp[i]);
            for(int j = 0;j<i;j++){
                //compare len , wid and height.
                if(A[i][0] >= A[j][0] && A[i][1] >= A[j][1] && A[i][2] >= A[j][2]){
                    dp[i] = Math.max(dp[i],dp[j] + A[i][2]);
                    max = Math.max(dp[i],max);
                }
            }
        }
        
        return max;
    }
}