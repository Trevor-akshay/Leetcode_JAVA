class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
    Set<List<Integer>> set = new HashSet<>();
        permuteUniqueHelper(set,new ArrayList<>(),nums,new boolean[nums.length]);

        return new ArrayList<>(set);
    }

    static private void permuteUniqueHelper(Set<List<Integer>> set,List<Integer> list,
                                            int[] nums,boolean[] visited){
        if(list.size() == nums.length){
            set.add(new ArrayList<>(list));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if(visited[i])
                continue;
            visited[i] = true;
            list.add(nums[i]);
            permuteUniqueHelper(set,list,nums,visited);
            list.remove(list.size()-1);
            visited[i] = false;
            }
    }
}

