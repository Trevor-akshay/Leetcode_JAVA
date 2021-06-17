class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> subset = new LinkedHashSet<>();
        subsetHelper(nums,subset,new ArrayList<Integer>(),0);
        return new ArrayList<>(subset);
    }

    static private void subsetHelper(int[] nums, Set<List<Integer>> subset, ArrayList<Integer> list, int pos){
        if(pos > nums.length)
            return;
        subset.add(new ArrayList<>(list));
        for(int i = pos;i<nums.length;i++){
           list.add(nums[i]);
            subsetHelper(nums,subset,list, i+1);
            list.remove(list.size()-1);
        }
    }
}
