class Solution {
    Set<List<Integer>> list = new HashSet<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        helper(nums,new ArrayList<>(),0);
        
        return new ArrayList<>(list);
    }
    
    private void helper(int[] nums,List<Integer> temp,int index){
        if(temp.size() > 1){
            list.add(new ArrayList<>(temp));
        }
        for(int i = index;i<nums.length;i++){
            if(temp.size() == 0 || nums[i] >= temp.get(temp.size()-1)){
                temp.add(nums[i]);
                helper(nums,temp,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}