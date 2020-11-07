class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length < 4) return new ArrayList<>();
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0;i<nums.length-2;i++){
            for(int j = i+1;j<nums.length-1;j++){
                int k = j+1;
                int m = nums.length-1;
                while(k<m){
                    int sum = nums[i]+nums[j]+nums[k]+nums[m];
                    if(sum == target)
                        set.add(Arrays.asList(nums[i],nums[j],nums[k++],nums[m--]));
                    else if (sum > target)
                        m--;
                    else
                        k++;
                }
            }
        }
        return new ArrayList<>(set);
    }
}