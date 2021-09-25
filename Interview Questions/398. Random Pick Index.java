class Solution {
    Map<Integer,List<Integer>> map = new HashMap<>();
    Random rand;
    public Solution(int[] nums) {
        rand = new Random();
        int i = 0;
        for(var num : nums){
            map.putIfAbsent(num,new ArrayList<>());
            map.get(num).add(i);
            i++;
        }
    }
    
    public int pick(int target) {
        int index = rand.nextInt(map.get(target).size());
        return map.get(target).get(index);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */