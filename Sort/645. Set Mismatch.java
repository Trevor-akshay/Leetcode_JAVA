class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int sum = n * (n+1)/2;
        
        int duplicate = 0;
        Set<Integer> set = new HashSet<>();
        
        for(var num : nums){
            if(set.contains(num))
                duplicate = num;
            sum -= num;
            set.add(num);
        }
        
        return new int[]{duplicate,sum + duplicate};
    }
}