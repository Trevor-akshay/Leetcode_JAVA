class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(candidates);
        combinationSum2Helper(set,new ArrayList<>(),candidates,target,0);

        return new ArrayList<>(set);
    }

    private void combinationSum2Helper(Set<List<Integer>> set,List<Integer> list,
                                              int[] candidates,int target,int start){
        if(target < 0)
            return;
        else if(target == 0)
            set.add(new ArrayList<>(list));

        else{
            for(int i =start;i<candidates.length;i++){
                if(target - candidates[i] < 0)
                    break;
                list.add(candidates[i]);
                combinationSum2Helper(set,list,candidates,target - candidates[i],i+1);
                list.remove(list.size()-1);
            }
        }
    }
}