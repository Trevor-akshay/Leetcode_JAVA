	class Solution {
    public int numSubseq(int[] nums, int target) {	
		Arrays.sort(nums);
        long numSubSeq = 0;
        int left= 0,right=nums.length-1;
        while(left<=right){
            if(nums[left]+nums[right] <= target){
                numSubSeq+=Math.pow(2,right-left);
                left++;
            }else
                right--;

        }
        System.out.println(numSubSeq);
        return (int)(numSubSeq%(Math.pow(10,9)+7));
	}
	}