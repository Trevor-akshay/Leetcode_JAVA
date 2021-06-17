class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        Set<List<Integer>> set = new HashSet<>();
        combinationSum3Helper(nums,set,new ArrayList<>(),k,n,0);

        return new ArrayList<>(set);
    }

    static private void combinationSum3Helper(int[] nums,Set<List<Integer>> set,List<Integer> list,
                                              int k,int target,int start){
        if(target < 0)
            return;
        else if(target == 0 && list.size() == k)
            set.add(new ArrayList<>(list));
        else{
            for(int i =start;i<nums.length;i++){
                if(target - nums[i] < 0)
                    break;;
                list.add(nums[i]);
                combinationSum3Helper(nums,set,list,k,target - nums[i],i+1);
                list.remove(list.size()-1);
            }
        }
    }
}