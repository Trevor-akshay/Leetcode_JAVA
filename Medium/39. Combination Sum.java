class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
         Set<List<Integer>> set = new LinkedHashSet<>();

        combinationSumHelper(set,new ArrayList<>(),candidates,target,0);

        return new ArrayList<>(set);
    }

    static private void combinationSumHelper(Set<List<Integer>> set,List<Integer> list ,
                                             int[] candidates,int target,int start){
        if(target < 0)
            return;
        else if(target == 0)
            set.add(new ArrayList<>(list));
        else{
            for(int i = start;i<candidates.length;i++){
                list.add(candidates[i]);
                combinationSumHelper(set,list,candidates,target-candidates[i],i);
                list.remove(list.size()-1);
            }
        }
    }
}
