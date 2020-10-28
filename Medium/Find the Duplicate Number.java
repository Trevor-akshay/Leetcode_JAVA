class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int item : nums)
            map.put(item,map.getOrDefault(item,0)+1);
        for(int value : map.keySet())
            if(map.get(value) > 1)
                return value;
        return -1;
    }
}