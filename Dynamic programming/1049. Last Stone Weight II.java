class Solution {
    public int lastStoneWeightII(int[] stones) {
       int sum = Arrays.stream(stones).sum();
       Integer[][] memo = new Integer[stones.length][sum];
       return helper(0,stones,memo,0,0); 
    }
    
    private int helper(int index,int[] stones,Integer[][] memo,int sumL,int sumR){
        if(index == stones.length)
            return Math.abs(sumL - sumR);
        
        if(memo[index][sumL] != null)
            return memo[index][sumL];
        
        int left = helper(index + 1,stones,memo,sumL + stones[index],sumR);
        int right = helper(index + 1,stones,memo,sumL,sumR + stones[index]);
        
        memo[index][sumL] = Math.min(left,right);
        
        return memo[index][sumL];
    }
}