class Solution {
    public int superEggDrop(int k, int n) {
        Integer[][] memo = new Integer[k + 1][n + 1];
        return helper(k,n,memo);
    }
    
    private int helper(int eggs,int floor,Integer[][] memo){
        if(eggs == 1 || floor <= 1)
            return floor;
        
        if(memo[eggs][floor] == null){
            int min = Integer.MAX_VALUE;
            int left = 1,right = floor;
            
            while(left <= right){
                int mid = (left + right) >> 1;
                int breaks = helper(eggs - 1,mid - 1,memo);
                int survives = helper(eggs,floor - mid,memo);
                
                int max = Math.max(breaks,survives) + 1;
                if(breaks < survives)
                    left = mid + 1;
                else
                    right = mid - 1;
                
                min = Math.min(min,max);
            }
            
            memo[eggs][floor] = min;   
        }
        return memo[eggs][floor];
    }
}



class Solution {
    public int superEggDrop(int k, int n) {
        Integer[][] memo = new Integer[n + 1][k + 1];
        return helper(k,n,memo);
    }
    
    private int helper(int eggs,int floor,Integer[][] memo){
        if(eggs == 1 || floor <= 1)
            return floor;
        
        if(memo[floor][eggs] == null){
            int min = Integer.MAX_VALUE;
            for(int i = 1;i<=floor;i++)
                min = Math.min(min,1 + Math.max(helper(eggs - 1,i - 1,memo),
                                        helper(eggs,floor - i,memo)));
            
            memo[floor][eggs] = min;   
        }
        return memo[floor][eggs];
    }
}