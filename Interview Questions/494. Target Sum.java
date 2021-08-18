class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums==null || nums.length==0)
            return 0;
        return dfs(nums,S,0,0,new HashMap<>());
    }
    public int dfs(int[] nums,int S,int index,int sum,Map<String,Integer> map){
        if(index==nums.length){
            if(sum==S){
                return 1;
            }else
                return 0;
        } 
        String key=index+"->"+sum;
        if(map.containsKey(key))
            return map.get(key);
        int pos=dfs(nums,S,index+1,sum+nums[index],map);
        int neg=dfs(nums,S,index+1,sum-nums[index],map);
        map.put(key,pos+neg);
        return pos+neg;
    }
}