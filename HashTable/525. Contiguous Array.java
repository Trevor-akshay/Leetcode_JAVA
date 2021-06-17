class Solution {
    public int findMaxLength(int[] nums) {
        int length= 0;
        for(int i =0 ;i<nums.length;i++)
            nums[i] = nums[i] == 0 ? -1:1;
        int presum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        
        for(int i=0;i<nums.length;i++){
            presum = nums[i] == 1? presum+1:presum-1;
            if(map.containsKey(presum))
                length = Math.max(length,i-map.get(presum));
            else
                map.put(presum,i);
        }
        return length;
    }
}