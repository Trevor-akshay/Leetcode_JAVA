class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        Integer[][] memo = new Integer[satisfaction.length][satisfaction.length + 1];
        return helper(0,satisfaction,1,memo);
    }

    static private int helper(int index,int[] satisfaction,int value,Integer[][] memo){
        if(index == satisfaction.length)
            return 0;
        if(memo[index][value] != null)
            return memo[index][value];
        int p1 = helper(index + 1, satisfaction, value + 1,memo) + 
                    (satisfaction[index] * value);
        int p2 = helper(index + 1, satisfaction,value,memo);
        return memo[index][value] = Math.max(p1,p2);
          
    }
}