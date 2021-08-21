class Solution {
    public int minOperations(int[] nums, int x) {
        Map<String,Integer> memo = new HashMap<>();
        int result = helper(0,nums.length-1,memo,nums,x);
        return  result > nums.length ? -1 : result;
    }

    private int helper(int i,int j,Map<String,Integer> memo,int[] nums,int x){
        if(x == 0)
            return 0;
        else if(i > j || x < 0)
            return nums.length;   
        String temp = i + " " + j + " " +x;
        if(memo.containsKey(temp))
            return memo.get(temp);

        int include = 1 + helper(i + 1,j,memo,nums,x - nums[i]);
        int exclude = 1 + helper(i,j - 1,memo,nums,x - nums[j]); 

        memo.put(temp,Math.min(include,exclude));
        return memo.get(temp);
    }
}