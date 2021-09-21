class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides,(a,b) -> a[0] - b[0]);
        Long[] memo = new Long[rides.length + 1];
        return helper(0,rides,memo);
    }
    
    private long helper(int i,int[][] A,Long[] memo){
        if(i >= A.length)
            return 0;
        
        if(memo[i] == null){
            int next = findNext(A,i);
            long c1 = A[i][1] - A[i][0] + A[i][2];
            if(next != -1){
                c1 += helper(next,A,memo);
            }
            long c2 = helper(i + 1,A,memo);
            
            memo[i] = Math.max(c1,c2);
        }
        return memo[i];    
    }
    
    private int findNext(int[][] A,int i){
        int left = i;
        int right = A.length-1;
        
        while(left <= right){
            int mid = (left + right) >> 1;
            if(A[mid][0] >= A[i][1]){
                if(mid == 0 || A[mid - 1][0] < A[i][1])
                    return mid;
                right = mid - 1;
            }else
                left = mid + 1;
        }
        
        return -1;
    }
}