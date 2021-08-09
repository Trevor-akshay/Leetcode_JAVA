class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int sum = 0;
        for(int num : nums){
            sum += num;
            if(map.containsKey(sum - goal)){
                count += map.get(sum - goal);
            }
            map.merge(sum,1,Integer::sum);
        }       
        return count;
    }
}