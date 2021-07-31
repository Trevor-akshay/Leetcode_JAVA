class Solution {
    public int countNicePairs(int[] nums) {
        Map<Long,Integer> map = new HashMap<>();
        int mod = (int)(1e9 + 7);
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            long diff = nums[i] - reverse(nums[i]);
            if(map.containsKey(diff))
                   count= ((count % mod) + (map.get(diff) % mod)) % mod;
            
            map.merge(diff,1,Integer::sum);
        }
        
        return count;
    }
    
    private int reverse(int num){
        int res = 0;
        while(num != 0){
            res = (res * 10) + (num % 10);
            num /= 10;
        }
        
        return res;
    }
}