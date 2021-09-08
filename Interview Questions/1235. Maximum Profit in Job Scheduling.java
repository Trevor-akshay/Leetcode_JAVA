class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] prof) {        
        int maximumProfit = 0;
        int[][] jobProfit = new int[startTime.length][3];
        for(int i = 0;i<startTime.length;i++){
            jobProfit[i][0] = startTime[i];
            jobProfit[i][1] = endTime[i];
            jobProfit[i][2] = prof[i];
        }
        
        Arrays.sort(jobProfit,(a,b) -> a[0] - b[0]);
        Integer[] memo = new Integer[jobProfit.length + 1];
        return helper(0,jobProfit,memo);
    }
    
    private int helper(int index,int[][] jobProfit,Integer[] memo){
        if(index == jobProfit.length)
            return 0;
        
        if(memo[index] != null)
            return memo[index];
        
        int c1 = jobProfit[index][2];
        int next = findNextLargerStartIndex(jobProfit,index);
        if(next != -1)
            c1 += helper(next,jobProfit,memo);
        
        int c2 = helper(index + 1,jobProfit,memo);
        
        return memo[index] = Math.max(c1,c2);
    }
    
    private int findNextLargerStartIndex(int[][] jobProfit,int prev){
        int left = prev;
        int right = jobProfit.length-1;
        
        while(left <= right){
            int mid = (left + right) / 2;
            if(jobProfit[mid][0] >= jobProfit[prev][1]){
                if(mid > 0 && jobProfit[mid - 1][0] < jobProfit[prev][1])
                    return mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        return -1;
    }
}