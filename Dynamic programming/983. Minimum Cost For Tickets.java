class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Integer[] memo = new Integer[days.length];
        
        return helper(0,days,costs,memo);
    }
    
    private int helper(int index,int[] days,int[] costs,Integer[] memo){
        if(index == days.length)
            return 0;
        else if(memo[index] != null)
            return memo[index];
        
        int onePass = helper(index + 1,days,costs,memo) + costs[0];
        int i = index;
        for(i=index;i<days.length;i++){
            if(days[index] + 7 <= days[i])
                break;
        }
        int sevenPass = helper(i,days,costs,memo) + costs[1];
        i = index;
        for(;i<days.length;i++){
            if(days[index] + 30 <= days[i])
                break;
        }
        
        int thirtyPass = helper(i,days,costs,memo) + costs[2];
        
        return memo[index] = Math.min(onePass,Math.min(sevenPass,thirtyPass));
    }
}