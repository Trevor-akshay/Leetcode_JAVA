class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        permuteHelper(nums,set,new ArrayList<>());
        return new ArrayList<>(set);
    }

    static private void permuteHelper(int[] nums,Set<List<Integer>> set,List<Integer> list){
        if(list.size() == nums.length){
            set.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(list.contains(nums[i]))
                continue;
            list.add(nums[i]);
            permuteHelper(nums,set,list);
            list.remove(list.size()-1);
        }
    }
}