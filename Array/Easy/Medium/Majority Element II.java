class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new LinkedList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int item : nums)
            map.put(item,map.getOrDefault(item,0)+1);

        for(int values : map.keySet())
            if(map.get(values) > nums.length/3)
                list.add(values);

        return list;
    }
}