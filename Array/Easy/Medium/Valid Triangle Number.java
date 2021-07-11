class Solution {
    public int triangleNumber(int[] nums) {
        if(nums.length < 3)return 0;
        Arrays.sort(nums);
        int triangleCount = 0;
        for(int i=0;i<nums.length-2;i++){
            if(nums[i] != 0){
                for(int j=i+1;j<nums.length-1;j++){
                    int sum = nums[i] + nums[j];
                    for(int m=j+1;(m<nums.length && nums[m]<sum);m++){
                        triangleCount++;
                    }
                }
            }
        }
        return triangleCount;
    }
}