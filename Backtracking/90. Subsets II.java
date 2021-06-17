class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> subSet  = new LinkedHashSet<>();
        Arrays.sort(nums);
        subsetDupsHelper(subSet,new ArrayList<>(),nums,0);

        return new ArrayList<>(subSet);
    }

    static private void subsetDupsHelper(Set<List<Integer>> subset,List<Integer> list,
                                            int[] nums,int start){

        subset.add(new ArrayList<>(list));
        for(int i = start;i<nums.length;i++){
            list.add(nums[i]);
            subsetDupsHelper(subset,list,nums,i+1);
            list.remove(list.size()-1);
        }

    }
}