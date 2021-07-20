class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length % k != 0)
            return false;
        
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
        for(var num : nums)
            map.merge(num,1,Integer::sum);
        
        int first = -1;
        for(int i = 0;i<nums.length;i++){
            if(i != 0 && i % k == 0)
                first = -1;
            
            if(first == -1){
                var entry = map.pollFirstEntry();
                first = entry.getKey();
                int value = entry.getValue() - 1;
                if(value > 0)
                    map.put(first,value);
            }else if(map.containsKey(first + 1)){
                var value = map.get(first + 1) - 1;
                if(value > 0)
                    map.replace(first+1,value);
                else
                    map.remove(first+1);
                first++;
            }else
                return false;
        }
        
        return true;
    }
}